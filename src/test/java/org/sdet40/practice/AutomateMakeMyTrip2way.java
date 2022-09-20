 package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateMakeMyTrip2way {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("makemytrip");
		 String fromcitycode=sh.getRow(1).getCell(0).getStringCellValue();
		 String tocitycode=sh.getRow(1).getCell(1).getStringCellValue();
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://www.makemytrip.com/");
		 driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		 driver.findElement(By.xpath("//span[text()='From']")).click();
			driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromcitycode);
			driver.findElement(By.xpath("//div[text()='"+fromcitycode+"']")).click();
			
				driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(tocitycode);
				driver.findElement(By.xpath("//div[text()='"+tocitycode+"']")).click();
				driver.findElement(By.xpath("//a[text()='Search']")).click();

		 
		
	}

}