package org.zalando.onlineObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageByMap {

	private WebDriver driver;
	// declaration
		@FindBy(id="inputEmail") private WebElement UserNameTextField;
		@FindBy(id="inputPassword") private WebElement PasswordTextField;
		@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
		

		//intialization
	public LoginPageByMap(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		//bussiness library
	public void LoginAction(Map<String,String>map)
	{
		UserNameTextField.sendKeys(map.get("UserName"));
		PasswordTextField.sendKeys(map.get("password"));
		loginButton.click();
	}
		
		
	}
