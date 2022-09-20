package org.sdet40.practice;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel= new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fisExcel);
		 Sheet sh = wb.getSheet("commondata");
		 Row rw=sh.getRow(1);
		 Cell cl=rw.getCell(1);
		 String ur=cl.getStringCellValue();
		 System.out.println(ur);
		 wb.close();
		 
		//
		
	}
}