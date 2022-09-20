package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelSheet2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel= new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fisExcel);
		try {
			Sheet sh=wb.getSheet("Sheet3");
			int data=(int)sh.getRow(0).getCell(0).getNumericCellValue();
			// when we have a numeric cell value
			int data1=(int)sh.getRow(1).getCell(0).getNumericCellValue();
			System.out.println(data1);
		
			System.out.println(data);
		}
			
		finally {
			wb.close();
		}
}
}