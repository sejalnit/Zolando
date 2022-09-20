package org.zalando.onlineObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryByMap {

	private WebDriver driver;
	
	@FindBy(xpath="//input[@type='text']") private WebElement CategoryName;
	@FindBy(xpath="//textarea[@class='span8']") private WebElement CategoryDescription;
	@FindBy(xpath="//button[@type='submit']") private WebElement Create;
	 
	   public AddCategoryByMap(WebDriver driver) {
		   
		PageFactory.initElements(driver, this);
	}
	   public void categoryByMap(Map<String,String>map) {
		   CategoryName.sendKeys(map.get("CategoryName"));
		   CategoryDescription.sendKeys(map.get("CategoryDescription"));
		   Create.click();
		   
	   }
}
