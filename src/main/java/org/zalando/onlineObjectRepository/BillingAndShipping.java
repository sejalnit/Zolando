package org.zalando.onlineObjectRepository;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingAndShipping {
	@FindBy(name="billingaddress")
	private WebElement billing;
	@FindBy(id="bilingstate")
	private WebElement billingstate;
	@FindBy (id="billingcity")
	private WebElement billingcity;
	@FindBy(id="billingpincode")
	private WebElement billingpincode;
	@FindBy(name="shippingaddress")
	private WebElement shippingAdd;
	@FindBy(id="shippingstate")
	private WebElement shippingState;
	@FindBy(id="shippingcity")
	private WebElement shippincity;
	@FindBy(id="shippingpincode")
	private WebElement shippinpincode;
	@FindBy(xpath="//button[text()='PROCCED TO CHEKOUT']")
	private WebElement click;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;


public void Billing(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void billingandshipping(Map<String,String>map)
{
	

 billing.sendKeys(map.get("bill"));
billingstate.sendKeys(map.get("billstate"));
billingcity.sendKeys(map.get("bilcity"));
billingpincode.sendKeys(map.get("billpin"));
shippingAdd.sendKeys(map.get("shippadd"));
shippingState.sendKeys(map.get("shippState"));
shippincity.sendKeys(map.get("shippCity"));
shippinpincode.sendKeys(map.get("shippPinCode"));
}
}

