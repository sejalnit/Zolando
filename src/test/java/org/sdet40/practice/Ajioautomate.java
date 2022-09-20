package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajioautomate {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("ajio");
		 String productName=sh.getRow(1).getCell(0).getStringCellValue();
		 
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='KIDS']")).click();
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
	String productprice = driver.findElement(By.xpath("((//div[contains(@class,'contentHolder')])[1]//span[contains(@class,'price')])[1]")).getText();
	System.out.println(productprice);
	FileOutputStream fos=new FileOutputStream("./src/test/resources/Book1.xlsx");
	Workbook wc = WorkbookFactory.create(fis);
	Sheet  sh1 =wc.getSheet("ajio");
	sh.getRow(1).createCell(1).setCellValue(productprice);
	wb.write(fos);
	
//	driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();		

}
}