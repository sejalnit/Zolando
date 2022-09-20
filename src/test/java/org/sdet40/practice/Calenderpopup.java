package org.sdet40.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderpopup {

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
			driver.findElement(By.id("datepicker")).click();
			String date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println(date);
	}

}
