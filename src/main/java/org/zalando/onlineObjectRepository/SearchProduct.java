package org.zalando.onlineObjectRepository;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {

	private WebDriver driver;

   @FindBy (xpath="//input[@class='search-field']")private WebElement searchfield;
	@FindBy(xpath="//button[@class='search-button']")private WebElement button;

 public void Search(WebDriver driver) {
	   
	PageFactory.initElements(driver, this);
	}

 public void searchBYproduct(Map<String,String>map){
	 searchfield.sendKeys(map.get("product name"));
	 button.click();
 }
 
}