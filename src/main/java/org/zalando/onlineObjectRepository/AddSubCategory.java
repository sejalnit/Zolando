package org.zalando.onlineObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zalando.GenericUtility.WebDriverUtility;

public class AddSubCategory {
	private WebElement driver;
	WebDriverUtility wb=new WebDriverUtility();
	
@FindBy(xpath="//input[@name='subcategory']") private WebElement Subcategory;
@FindBy(xpath="//select[@name='category']") private WebElement dropdownCategory;
@FindBy(xpath="//button[@name='submit']") private WebElement submit;
public AddSubCategory (WebDriver driver)
{
PageFactory.initElements(driver, this);
	}

public void addSubCategory(String catagoryName, String subCategoryName)
{
	wb.dropdown(dropdownCategory, catagoryName);
	Subcategory.sendKeys(subCategoryName);
	submit.click();
}
}
