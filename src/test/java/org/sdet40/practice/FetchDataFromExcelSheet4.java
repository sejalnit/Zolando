package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelSheet4 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb=  WorkbookFactory.create(fis);
		try {
			Sheet sh = wb.getSheet("Sheet3");
			String data=sh.getRow(0).getCell(0).toString();
			System.out.println(sh);
			}
		finally {
			wb.close();
		}

}
}
