package org.zalando.onlineObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 // declaration
	@FindBy(id="inputEmail") private WebElement UserNameTextField;
	@FindBy(id="inputPassword") private WebElement PasswordTextField;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;


	//intialization
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	
	//bussiness library
public void LoginAction(String UserName,String password)
{
	UserNameTextField.sendKeys(UserName);
	PasswordTextField.sendKeys(password);
	loginButton.click();
}
	
	
}