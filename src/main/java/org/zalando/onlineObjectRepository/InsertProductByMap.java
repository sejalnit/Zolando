package org.zalando.onlineObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zalando.GenericUtility.JavaUtility;
import com.zalando.GenericUtility.WebDriverUtility;

public class InsertProductByMap {
	WebDriverUtility web = new WebDriverUtility();
	

	@FindBy(xpath = "//select[@name='category']")
	private WebElement dropdownCategory;

	@FindBy(xpath = "//select[@name='subcategory']")
	private WebElement Subcategory;
	@FindBy(xpath = "//select[@name='subcategory']")
	private WebElement dropdownSubcategory;

	@FindBy(xpath = "//input[@name='productName']")
	private WebElement Productname;
	@FindBy(xpath = "//input[@name='productCompany']")
	private WebElement ProductCompany;
	@FindBy(xpath = "//input[@name='productpricebd']")
	private WebElement ProductPrice;
	@FindBy(xpath = "//input[@name='productprice']")
	private WebElement ProductdiscountPrice;
	@FindBy(xpath = "//textarea[@class='span8 tip']")
	private WebElement ProductDescrptn;
	@FindBy(xpath = "//input[@name='productShippingcharge']")
	private WebElement Shipping;
	@FindBy(xpath = "//select[@name='productAvailability']")
	private WebElement ProductAvail;
	@FindBy(xpath = "//input[@id='productimage1']")
	private WebElement Image1;
	@FindBy(xpath = "//input[@name='productimage2']")
	private WebElement Image2;
	@FindBy(xpath = "//input[@name='productimage3']")
	private WebElement Image3;
	@FindBy(xpath = "//button[text()='Insert']")
	private WebElement click;

	public InsertProductByMap(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public void InserActionByMap(Map<String, String> map) // by using map
	{
		dropdownCategory.click();
		 web.dropdown(dropdownCategory, (map.get("CategoryName")));
		
		dropdownSubcategory.click();
		web.dropdown(dropdownSubcategory, (map.get("Subcategory")));
		

		  Productname.sendKeys(map.get("product name"));
		ProductCompany.sendKeys(map.get("product company"));
		ProductPrice.sendKeys(map.get("product price"));
		ProductdiscountPrice.sendKeys(map.get("product discount"));
		ProductDescrptn.sendKeys(map.get("product descrptn"));
		Shipping.sendKeys(map.get("product shipping"));
		ProductAvail.sendKeys(map.get("product availability"));
		Image1.sendKeys(map.get("prod image1"));
		Image2.sendKeys(map.get("prod image2"));
		Image3.sendKeys(map.get("prod image3"));
		click.click();
	}

}
