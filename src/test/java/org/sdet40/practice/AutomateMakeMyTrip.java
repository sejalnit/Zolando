package org.sdet40.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateMakeMyTrip {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@type='text' and@ aria-autocomplete='list']")).sendKeys("mumbai");
driver.findElement(By.xpath("//p[text()='Mumbai, India'] ")).click();
	driver.findElement(By.xpath("//input[@type='text' and @autocomplete='off']")).sendKeys("bangkok thailand");
	driver.findElement(By.xpath("//p[text()='Bangkok, Thailand']")).click();
	driver.findElement(By.xpath("//a[text()='Search']")).click();

	
	}

}
