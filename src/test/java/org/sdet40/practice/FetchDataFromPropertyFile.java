package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
	public static void main(String[]arg) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/LocalHost.properties");
				Properties property=new Properties();
				property.load(fis);
				String url=property.getProperty("url").trim();
				String brwsr=property.getProperty("browser").trim();
				String pwd=property.getProperty("password").trim();
				System.out.println(url);
				System.out.println(brwsr);
	            System.out.println(pwd);
	
				
	}

}
