package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class CreateAndSetDataFrmExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("organization");
	    Row rw = sh.getRow(9);
	 Cell cl=rw.getCell(0);
	 cl.setCellValue("ts8");
	 FileOutputStream fos = new FileOutputStream("./src/test/resources/Book1.xlsx");
	 wb.write(fos);
	 System.out.println("data updated");
	 wb.close();
}
}