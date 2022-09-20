package org.sdet40.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		String browser ="firefox";
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			}
		else {
			System.out.println();
		}
		
		

	}

}
