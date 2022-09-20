package ByUsingPomAndMap;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.zalando.onlineObjectRepository.CommonPage;
import org.zalando.onlineObjectRepository.MyAccountPage2;

import com.zalando.GenericUtility.ExcelUtility;
import com.zalando.GenericUtility.FileUtility;
import com.zalando.GenericUtility.IConstantPath;
import com.zalando.GenericUtility.WebDriverUtility;

public class Automate3byMapPOM {

	public static void main(String[] args) throws IOException {

		WebDriverUtility web= new WebDriverUtility();
		ExcelUtility exe = new ExcelUtility();
		FileUtility file = new FileUtility();

		file.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		exe.OpenExcel(IConstantPath.EXCE_PATH);
		String browser = file.getDataFromPropertyFile("browser");
		
		WebDriver driver = web.openBrowserwithApplication(browser, 10, "http://rmgtestingserver/domain/Online_Shopping_Application");
	
	
		CommonPage com = new CommonPage(driver);
		com.MyAccountClick();
		
		MyAccountPage2 myacc = new MyAccountPage2();
		String user = file.getDataFromPropertyFile("userlogin");
		String pass = file.getDataFromPropertyFile("passrd");
		myacc.userLoginAction(user, pass);

	}

}
