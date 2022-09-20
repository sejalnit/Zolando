package ByUsingPomAndMap;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zalando.GenericUtility.ExcelUtility;
import com.zalando.GenericUtility.FileUtility;
import com.zalando.GenericUtility.IConstantPath;
import com.zalando.GenericUtility.WebDriverUtility;

public class AutomationFirstTestCase {
public static void main(String[] args) throws IOException {
	WebDriverUtility w=new WebDriverUtility();
	ExcelUtility ex=new  ExcelUtility();
	FileUtility f=new FileUtility();
	
	f.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
	
	String browser=f.getDataFromPropertyFile("browser");
	//String url=f.getDataFromPropertyFile("url");
	WebDriver driver=w.openBrowserwithApplication(browser, 10,"http://rmgtestingserver/domain/Online_Shopping_Application/admin/");

	String urname=f.getDataFromPropertyFile("username");
	String psswd=f.getDataFromPropertyFile("password");
	
	driver.findElement(By.id("inputEmail")).sendKeys(urname);
	driver.findElement(By.id("inputPassword")).sendKeys(psswd);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	 ex.OpenExcel( IConstantPath.EXCE_PATH);
	driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
	 
    String groc=ex.getDataFromExcel11("first1",0,1);
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys(groc);
    String grocdesc=ex.getDataFromExcel11("first1",12,1);
	 driver.findElement(By.xpath("//textarea[@class='span8']")).sendKeys(grocdesc);
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 
    WebElement show=driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
     Select s1= new Select(show);
     s1.selectByVisibleText("100");
     if (driver.findElement(By.xpath("//td[text()='grocery']")).getText().equals(groc)) {
    	 System.out.println("category gets created");
		} else {
		System.out.println("category not created");
}
     
   
     driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
   driver.findElement(By.xpath("//input[@type='text']")).sendKeys(groc);
    // Select s8 =new Select(sub);
   // s8.selectByVisibleText("grocery");
      String subcat = ex.getDataFromExcel11("first1",1,1);
    WebElement ele = driver.findElement(By.xpath("//select[@name='category']"));
    Select s3=new Select(ele);
    s3.selectByVisibleText(groc);
    driver.findElement(By.xpath("//button[@name='submit']")).click();
    WebElement chose=driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
    Select s2=new Select(chose);
    s2.selectByVisibleText("100");
    if (driver.findElement(By.xpath("//tbody//tr[last()]//td[2]")).getText().equals(groc)) {
    	System.out.println("subcategory gets created");
    } else {
    	System.out.println("subcategory not created");
    }
    
    driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/ul[2]/li[3]/a")).click();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(groc);
    driver.findElement(By.xpath("//select[@name='category']")).sendKeys(subcat);
    
    
     String proname = ex.getDataFromExcel11("first1",2,1);
    driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(proname);

    String procmpny = ex.getDataFromExcel11("first1",3,1);
driver.findElement(By.xpath("//input[@name='productCompany']")).sendKeys(procmpny);

   String proprice = ex.getDataFromExcel11("first1",4,1);
driver.findElement(By.xpath("//input[@name='productpricebd']")).sendKeys(proprice);

   String prodiscnt = ex.getDataFromExcel11("first1",5,1);
driver.findElement(By.xpath("//input[@name='productprice']")).sendKeys(prodiscnt);

    String prodescpn=ex.getDataFromExcel11("first1",7 ,1);
driver.findElement(By.xpath("//textarea[@class='span8 tip']")).sendKeys(prodescpn);

    String shipp=ex.getDataFromExcel11("first1", 8,1);
driver.findElement(By.xpath("//input[@name='productShippingcharge']")).sendKeys(shipp);
  

String proaval=ex.getDataFromExcel11("first1",6 ,1 );
driver.findElement(By.xpath("//select[@name='productAvailability']")).sendKeys(proaval);;



String proimg1 = ex.getDataFromExcel11("first1",9,1);
driver.findElement(By.xpath("//input[@id='productimage1']")).sendKeys(proimg1);
String proimg2 = ex.getDataFromExcel11("first1",10,1);
driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys(proimg2);
String proimg3 = ex.getDataFromExcel11("first1",11,1);
driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys(proimg3);
driver.findElement(By.xpath("//button[text()='Insert']")).click();


driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
WebElement dddd=driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
Select s5=new Select(dddd);
s5.selectByVisibleText("100");
if (driver.findElement(By.xpath("//tbody//tr[last()]//td[2]")).getText().equals(proname))

	System.out.println("product inserted");
 else {
 System.out.println("product not inserted");
driver.quit();

	System.out.println("test case is passed");
}
}
}