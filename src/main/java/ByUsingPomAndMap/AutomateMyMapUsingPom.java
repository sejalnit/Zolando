package ByUsingPomAndMap;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.zalando.onlineObjectRepository.AddCategoryByMap;
import org.zalando.onlineObjectRepository.AddSubCategoryByMap;
import org.zalando.onlineObjectRepository.CommonPage;
import org.zalando.onlineObjectRepository.InsertProductByMap;
import org.zalando.onlineObjectRepository.LoginPage;
import org.zalando.onlineObjectRepository.ManageCategoryBymap;

import com.zalando.GenericUtility.ExcelUtility;
import com.zalando.GenericUtility.FileUtility;
import com.zalando.GenericUtility.IConstantPath;
import com.zalando.GenericUtility.WebDriverUtility;

public class AutomateMyMapUsingPom {
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
		
		
	    AddCategoryByMap addcat = new AddCategoryByMap(driver);
		AddSubCategoryByMap addsubcat = new AddSubCategoryByMap(driver,w);
		InsertProductByMap bymap= new InsertProductByMap(driver);
		ManageCategoryBymap managecat = new ManageCategoryBymap(driver);
	   
		loginpage.LoginAction(urname, psswd);
		commnpge.Category1();
		addcat.categoryByMap(ex.getDataFromExcelByMap("first1"));

		commnpge.SubCategory();
		addsubcat.addSubCategory(ex.getDataFromExcelByMap("first1"));
	
		commnpge.insert();
		bymap.InserActionByMap(ex.getDataFromExcelByMap("first1"));
		//bymap.InserActionByMap(map);
  
      commnpge.manageuser();
	w.closeBrowser(driver);
}

	}
