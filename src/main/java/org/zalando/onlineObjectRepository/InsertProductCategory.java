package org.zalando.onlineObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zalando.GenericUtility.WebDriverUtility;

public class InsertProductCategory{
	WebDriverUtility web=new WebDriverUtility();
	
	@FindBy(xpath="//select[@name='category']") private WebElement dropdownCategory;
	
	@FindBy(xpath="//select[@name='subcategory']") private WebElement Subcategory ;
	@FindBy(xpath="//select[@name='subcategory']") private WebElement dropdownSubcategory;

	@FindBy(xpath="//input[@name='productName']") private WebElement Productname;
	@FindBy(xpath="//input[@name='productCompany']") private WebElement ProductCompany;
	@FindBy(xpath="//input[@name='productpricebd']") private WebElement ProductPrice;
	@FindBy(xpath="//input[@name='productprice']") private WebElement ProductdiscountPrice;
    @FindBy(xpath="//textarea[@class='span8 tip']") private WebElement ProductDescrptn;
    @FindBy(xpath="//input[@name='productShippingcharge']") private WebElement Shipping;
	@FindBy(xpath="//select[@name='productAvailability']") private WebElement ProductAvail;
	@FindBy(xpath="//input[@id='productimage1']") private WebElement Image1;
    @FindBy(xpath="//input[@name='productimage2']")  private WebElement Image2;
    @FindBy(xpath="//input[@name='productimage3']") private WebElement Image3;
    @FindBy(xpath="//button[text()='Insert']") private WebElement click;
    
    
     public InsertProductCategory(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
     
     public void InserAction( String category ,String subcategory,String productname,String productcomp, String productprice,String productdiscntprice,
	 String productdescrptn,String prodShipping,String ProdAvail,String  img1,String img2 ,String  img3) 
    	//public void InserAction(Map<String,String> map)
    	{
    	dropdownCategory.sendKeys(category);
    	dropdownCategory.click();
    	
    	Subcategory.sendKeys(subcategory);
    	web.dropdown(dropdownSubcategory, subcategory);
          dropdownSubcategory.click();
          
    	 Productname.sendKeys(productname);
    	 ProductCompany.sendKeys(productcomp);
    	 ProductPrice.sendKeys(productprice);
    	 ProductdiscountPrice.sendKeys(productdiscntprice);
    	 ProductDescrptn.sendKeys(productdescrptn);
    	 Shipping.sendKeys(prodShipping);
    	 ProductAvail.sendKeys(ProdAvail);
    	 Image1.sendKeys(img1);
    	 Image2.sendKeys(img2);
    	 Image3.sendKeys(img3);
    	 click.click();
    	}
    
}