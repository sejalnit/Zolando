package org.zalando.onlineObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zalando.GenericUtility.WebDriverUtility;

public class AddSubCategoryByMap {

	private WebElement driver;
	private WebDriverUtility wb;

	@FindBy(xpath = "//input[@name='subcategory']")
	private WebElement Subcategory;
	
	@FindBy(xpath = "//select[@name='category']")
	private WebElement dropdownCategory;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submit;

	public AddSubCategoryByMap(WebDriver driver, WebDriverUtility wb) {
		this.wb = wb;
		PageFactory.initElements(driver, this);
	}

	public void addSubCategory(Map<String, String> map) {
		wb.dropdown(dropdownCategory, map.get("CategoryName"));
		Subcategory.sendKeys(map.get("Subcategory"));
		submit.click();
	}
}
