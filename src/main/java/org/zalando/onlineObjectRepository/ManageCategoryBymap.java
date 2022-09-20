package org.zalando.onlineObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zalando.GenericUtility.WebDriverUtility;

public class ManageCategoryBymap {

WebDriverUtility wb=new WebDriverUtility();
	
	
	@FindBy(xpath=" //select[@name='DataTables_Table_0_length']")private WebElement dropdownCategory;
	
	public  ManageCategoryBymap(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
		}
			
	public void manageByMap(Map<String,String>map)
	 {
		wb.dropdown(dropdownCategory,(map.get("catagoryName")));
}
}
