package com.zalando.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	Workbook workbook;
	Sheet sheet;

	/**
	 * this method is used to initialize and open the workbook
	 * 
	 * @param excelPath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void OpenExcel(String excelPath) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		workbook = WorkbookFactory.create(fis);
	}

	public String getdataFomExcel(String sheetName, String requiredKey, String TestCaseName) {

		 sheet = workbook.getSheet(sheetName);
		String value = null;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			String actualTestCaseName = sheet.getRow(i).getCell(0).getStringCellValue();
			if (actualTestCaseName.equalsIgnoreCase(TestCaseName)) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String actualKey = sheet.getRow(i).getCell(j).getStringCellValue();
					if (actualKey.equalsIgnoreCase(requiredKey))
						value = sheet.getRow(i + 1).getCell(j).getStringCellValue();
					break;
				}
				break;
			}
		}
		return value;

	}

//	/**
//	 * this method is used to fetch the data from the excel
//	 * 
//	 * @param SheetName
//	 * @param rownumber
//	 * @param cellnumber
//	 * @return
//	 */
	public String getDataFromExcel11(String sheetName, int rownumber, int cellnumber) {

		 sheet = workbook.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(rownumber).getCell(cellnumber));
		return data;
	}

	/**
	 * This method is used to close the workbook
	 * 
	 * @throws IOException
	 */
	public void closeExcelWorkBook() throws IOException {
		workbook.close();
	}

	/**
	 * This method is used to set the data in the excel sheet
	 * 
	 * @param sheetName
	 * @param rollNumber
	 * @param cellNumber
	 * @param text
	 */

	public void setDataIntoExcel(String sheetName, int rollNumber, int cellNumber, String text) {
		sheet = workbook.getSheet(sheetName);
		sheet.getRow(rollNumber).createCell(cellNumber).setCellValue(text);

	}

	/**
	 * this method is used to fetch data from excel and store it in a map
	 * 
	 * @param sheetName
	 * @return
	 */

	public Map<String, String> getDataFromExcelByMap(String sheetName) {
		sheet = workbook.getSheet(sheetName);  
Map<String, String> map = new HashMap<String, String>();
		DataFormatter df = new DataFormatter();
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),
					df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
		return map;
	}

	/**
	 * this method is used to fetch the data from excel and store in list <map>
	 * 
	 * @param sheetName
	 * @return
	 */
	public List<Map<String, String>> getDataFromExcelInList(String sheetName) {
		 sheet = workbook.getSheet(sheetName);
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		DataFormatter df = new DataFormatter();
		for (int k = 0; k <= sheet.getLastRowNum(); k++) {
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), 
						df.formatCellValue(sheet.getRow(i).getCell(k)));
			}
			list.add(map);
		}
		return list;
	}

	/**
	 * this method is used to save the data into excel
	 * 
	 * @param outputPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveDataIntoExcel(String outputPath) throws FileNotFoundException, IOException {
		workbook.write(new FileOutputStream(outputPath));
	}
}
