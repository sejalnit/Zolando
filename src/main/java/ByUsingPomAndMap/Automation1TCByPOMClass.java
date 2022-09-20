
package ByUsingPomAndMap;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.zalando.onlineObjectRepository.AddCategory;
import org.zalando.onlineObjectRepository.AddSubCategory;
import org.zalando.onlineObjectRepository.CommonPage;
import org.zalando.onlineObjectRepository.InsertProductCategory;

import org.zalando.onlineObjectRepository.LoginPage;
import org.zalando.onlineObjectRepository.ManageCategory;

import com.zalando.GenericUtility.ExcelUtility;
import com.zalando.GenericUtility.FileUtility;
import com.zalando.GenericUtility.IConstantPath;
import com.zalando.GenericUtility.WebDriverUtility;

public class Automation1TCByPOMClass {

	public static void main(String[] args) throws IOException {
		WebDriverUtility w = new WebDriverUtility();
		ExcelUtility ex = new ExcelUtility();
		FileUtility f = new FileUtility();
		f.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		ex.OpenExcel(IConstantPath.EXCE_PATH);

		String browser = f.getDataFromPropertyFile("browser");
		String url = f.getDataFromPropertyFile("url");
		WebDriver driver = w.openBrowserwithApplication(browser, 10,
				"http://rmgtestingserver/domain/Online_Shopping_Application/admin/");

		String urname = f.getDataFromPropertyFile("username");
		String psswd = f.getDataFromPropertyFile("password");

		LoginPage loginpage = new LoginPage(driver);
		CommonPage commnpge = new CommonPage(driver);
		AddCategory addcat = new AddCategory(driver);
		AddSubCategory addsubcat = new AddSubCategory(driver);
		InsertProductCategory insert = new InsertProductCategory(driver);
		ManageCategory managecat = new ManageCategory(driver);
		
		loginpage.LoginAction(urname, psswd);
		commnpge.Category1();
		addcat.addCategory(ex.getDataFromExcel11("first1", 0, 1), ex.getDataFromExcel11("first1", 12, 1));

		commnpge.SubCategory();
		addsubcat.addSubCategory(ex.getDataFromExcel11("first1", 0, 1), ex.getDataFromExcel11("first1", 1, 1));
    // Map<String, String> map = ex.getDataFromExcelByMap("Sheet3");
    // insert.InserAction(map);
     
		commnpge.insert();
	        String category = ex.getDataFromExcel11("first1", 0, 1);
			String subcat = ex.getDataFromExcel11("first1", 1, 1); 
		     
     String productname = ex.getDataFromExcel11("first1", 2, 1);
				String productcompany = ex.getDataFromExcel11("first1", 3, 1);
				String disbefore = ex.getDataFromExcel11("first1", 4, 1); 
			String discntaftr = ex.getDataFromExcel11("first1", 5, 1);
			String proddescrptn = ex.getDataFromExcel11("first1", 7, 1); 
				String prodShipp = ex.getDataFromExcel11("first1", 8, 1);
			String prodAvailble = ex.getDataFromExcel11("first1", 6, 1);
				String image1 = ex.getDataFromExcel11("first1", 9, 1);
				String image2 = ex.getDataFromExcel11("first1", 10, 1); 
		String image3 = ex.getDataFromExcel11("first1", 11, 1);
        insert.InserAction(category, subcat, productname, productcompany, disbefore, discntaftr, 
						  proddescrptn, prodShipp, prodAvailble, image1, image2, image3);
     commnpge.manageuser();
       managecat. manage(ex.getDataFromExcel11("first1",3,1),"productcompany");
		
	}
	
}
	
	
	
	
	
	
	
