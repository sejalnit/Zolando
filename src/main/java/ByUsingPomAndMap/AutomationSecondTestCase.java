package ByUsingPomAndMap;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zalando.GenericUtility.ExcelUtility;
import com.zalando.GenericUtility.FileUtility;
import com.zalando.GenericUtility.IConstantPath;
import com.zalando.GenericUtility.WebDriverUtility;

public class AutomationSecondTestCase {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriverUtility wu= new WebDriverUtility();
	FileUtility fu= new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	

	fu.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
	
	String browser=fu.getDataFromPropertyFile("browser");
	
	
    WebDriver driver=wu.openBrowserwithApplication(browser, 10, 
    		"http://rmgtestingserver/domain/Online_Shopping_Application/");
    
	
     eu.OpenExcel(IConstantPath.EXCE_PATH);
	driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
	
	
	String fullname=eu.getDataFromExcel11("second",0 , 1);
	driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys(fullname);
	
	String mail=eu.getDataFromExcel11("second",1 , 1);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mail);
	
	String contno=eu.getDataFromExcel11("second",2, 1);
	driver.findElement(By.xpath("//input[@id='contactno']")).sendKeys(contno);
	
	String pass=eu.getDataFromExcel11("second",3 , 1);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
	
	String cnfpass=eu.getDataFromExcel11("second",4 , 1);
	driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys(cnfpass);
	
	driver.findElement(By.xpath("//button[.='Sign Up']")).click();

	
	wu.swithToAlertWindowAndAccpect(driver);
	
	String email=eu.getDataFromExcel11("second", 1, 1);
	driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);
String pas=eu.getDataFromExcel11("second",3 , 1);
	driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(pas);
	driver.findElement(By.xpath("//button[.='Login']")).click();
	System.out.println("login is successed");
	driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	System.out.println("Test Case is passed");
	driver.quit();
	
	

}
}
	
	
	
	
