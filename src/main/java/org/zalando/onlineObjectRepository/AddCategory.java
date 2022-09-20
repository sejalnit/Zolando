package org.zalando.onlineObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategory {
	
	private WebDriver driver;
	
@FindBy(xpath="//input[@type='text']") private WebElement CategoryName;
@FindBy(xpath="//textarea[@class='span8']") private WebElement CategoryDescription;
@FindBy(xpath="//button[@type='submit']") private WebElement Create;
 
   public AddCategory (WebDriver driver) {
	   
	PageFactory.initElements(driver, this);
}
   public WebElement addCategory(String catgrynme ,String catgryDescrptn) {
	   CategoryName.sendKeys(catgrynme);
	   CategoryDescription.sendKeys(catgryDescrptn);
	   Create.click();
	return Create;
	   
   }


}
