package org.sdet40.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vitigerOrganisation {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		  
		
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String expName="cognizant";
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	 List<WebElement> OrganisationList = driver.findElements(By.xpath("//table[@class=\"lvt small\"]//tr//a[@title='Organizations']"));
		for (WebElement org : OrganisationList) {
			String orgName = org.getText();
			if (orgName.equals(expName)) {
				driver.findElement(By.xpath(""));
				driver.switchTo().alert().accept();
				driver.findElement(By.xpath("//a[text()='expName']//parent::td/preceding-sibling::td/input")).click();
				break;
			}
		}
	driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		driver.switchTo().alert().accept();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
		
	
	}


}
