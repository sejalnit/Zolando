package org.zalando.onlineObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zalando.GenericUtility.WebDriverUtility;

public class ManageCategory {
	WebDriverUtility wb;
	WebDriver driver;
	
	
	@FindBy(xpath=" //select[@name='DataTables_Table_0_length']")private WebElement dropdownCategory;
	
	public  ManageCategory (WebDriver driver)
	{
	PageFactory.initElements(driver, this);
		}
			
	public void manage(String catagoryName, String subCategoryName)
	 {
		wb.dropdown(dropdownCategory, catagoryName);
}
}