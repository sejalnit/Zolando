package com.zalando.GenericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class TestingGenericUtility {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		new ExcelUtility().OpenExcel(IConstantPath.EXCE_PATH);
		String data=new ExcelUtility().getDataFromExcel11(IConstantPath.EXCE_PATH, 1,1);
	}

}
