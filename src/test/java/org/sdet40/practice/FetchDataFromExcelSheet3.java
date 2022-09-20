package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelSheet3 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb=  WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		try {
			Sheet sh = wb.getSheet("sheet3");
			Cell cl = sh.getRow(0).getCell(0);
			String data = df.formatCellValue(cl);
			System.out.println(data);
			}
		finally {
			wb.close();
		}
		
		
	}

}
