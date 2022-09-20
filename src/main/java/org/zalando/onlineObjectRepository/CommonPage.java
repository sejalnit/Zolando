package org.zalando.onlineObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zalando.GenericUtility.FileUtility;
import com.zalando.GenericUtility.WebDriverUtility;

public class CommonPage {
	
WebDriverUtility	driver1;

     //declaration
	 WebDriver driver;
	@FindBy(xpath = "//a[@class='collapsed']")
	private WebElement OrderManagement;
	@FindBy(xpath = "//a[@href='manage-users.php']")
	private WebElement ManageUser;
	@FindBy(xpath = "//a[text()=' Create Category ']")
	private WebElement CreateCategory;
	@FindBy(xpath = "//a[text()='Sub Category ']")
	private WebElement SubCategory;
	@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/ul[2]/li[3]/a")
	private WebElement InsertUser;
	@FindBy(xpath = "//a[@href='manage-products.php']")
	private WebElement ManageProduct;
	@FindBy(xpath = "//a[@ href='user-logs.php']")
	private WebElement UserLoginLog;
	@FindBy(xpath = "//a[@ href='user-logs.php']")
	private WebElement Logout;
	@FindBy(xpath = "//a[ @href='#']")
	private WebElement Admin;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement SubmitButton;
	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement MyAccount;

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement userlogout;
	@FindBy(xpath="//a[text()='Login']")
	private WebElement userlogin;
	
	
@FindBy(xpath="//button[@type='submit']")
private WebElement submit;

@FindBy(xpath="//button[text()='Add to cart']")
private WebElement addtoCartClick;

	
	
	

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void UserURL() {
		FileUtility file=new FileUtility();
		String bro = file.getDataFromPropertyFile("browser");
	driver= driver1.openBrowserwithApplication(bro, 10,
				"http://rmgtestingserver/domain/Online_Shopping_Application/");
		
		 	}

	public void Category1() {
		CreateCategory.click();
	}

	public void MyAccountClick() {
		MyAccount.click();
	}

	public void SubCategory() {
		SubCategory.click();
	}

	public void insert() {
		InsertUser.click();
	}

	public void manageuser() {
		ManageProduct.click();
	}

	public void adminlogout() {
		Logout.click();
	}

	public void userlogout() {
		userlogout.click();
	}
	
	public void userlogin() {
		 userlogin.click();
		
	}
	public void submitAndClick()
	{
		 submit.click();
		 addtoCartClick.click();
		 
		
	}

}