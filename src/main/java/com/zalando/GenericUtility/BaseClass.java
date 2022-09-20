package com.zalando.GenericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.zalando.onlineObjectRepository.CommonPage;
import org.zalando.onlineObjectRepository.LoginPage;

public class BaseClass {
	protected ExcelUtility exe;
	protected FileUtility file;
	protected WebDriverUtility web;
	protected LoginPage loginpage;
	protected WebDriver driver;
	protected String urname;
	protected String psswd;
	protected CommonPage commnpge;
	public static WebDriver sdriver;
	public static JavaUtility sjavaUtility;
	protected JavaUtility java;

	/**
	 * intialize allthe utility class open the excel nd proprerty file read the
	 * common data createthe instancefor browser(launch browser) maximize,implicit
	 * wait open the application intialize jsexecutor,actions,webdriverwait create
	 * the instance for common object repo
	 * 
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */
	@Parameters("browser")
	@BeforeClass
	public void classSetUp() throws EncryptedDocumentException, IOException {
		// create instance for the generic utility
		exe = new ExcelUtility();
		file = new FileUtility();
		web = new WebDriverUtility();
		sjavaUtility= java;
		file.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		exe.OpenExcel(IConstantPath.EXCE_PATH);

		String bro = file.getDataFromPropertyFile("browser");
		driver = web.openBrowserwithApplication(bro, 10,
				"http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		
		sdriver=driver;
		urname = file.getDataFromPropertyFile("username");
		psswd = file.getDataFromPropertyFile("password");

		// fetch the data from property file and excel sheet
		loginpage = new LoginPage(driver);
		commnpge = new CommonPage(driver);

	}

	@BeforeMethod
	public void methodsetup() {

		loginpage.LoginAction(urname, psswd);
	}

	@AfterMethod
	public void methodTeardown() {
		//commnpge.adminlogout();
		//commnpge.userlogout();
	}

	@AfterClass
	public void classTearDown()  {
		
		try {
			exe.closeExcelWorkBook();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		web.closeBrowser(driver);
	}

}
