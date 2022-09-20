package org.zalando.onlineObjectRepository;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zalando.GenericUtility.WebDriverUtility;

public class MyAccountPage2 {
	
	
	WebDriver driver;
	@FindBy(xpath="//input[@id='fullname']")
	private WebElement fullname;
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="contactno")
	private WebElement contactno;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="confirmpassword")
	private WebElement cnfrmpassword;
	@FindBy(xpath = "//button[.='Sign Up']")
	private WebElement signup;
	
	@FindBy(id="exampleInputEmail1")
	private WebElement singupemail;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement singuppassword;
	
	@FindBy(name="login")
	private WebElement loginsignup;

	public void MyAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void myAccountByMap(Map<String, String> map)  {

		fullname.sendKeys(map.get("fullName"));
		email.sendKeys(map.get("mail"));
		contactno.sendKeys(map.get("contactNum"));
		password.sendKeys(map.get("password"));
		cnfrmpassword.sendKeys(map.get("confirmpassword"));
		signup.click();
		WebDriverUtility web = new WebDriverUtility();
		web.swithToAlertWindowAndAccpect(driver);
	}		
		
		public void myAccountByMap2(Map<String,String>map) {
			
		singupemail.sendKeys(map.get("mail"));
		singuppassword.sendKeys(map.get("password"));
		loginsignup.click();
	}
		public void userLoginAction(String UserName,String password)
		{
			singupemail.sendKeys(UserName);
			singuppassword.sendKeys(password);
			loginsignup.click();
		}
}
