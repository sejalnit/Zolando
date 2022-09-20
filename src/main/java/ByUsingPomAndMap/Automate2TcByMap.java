package ByUsingPomAndMap;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.zalando.onlineObjectRepository.CommonPage;
import org.zalando.onlineObjectRepository.MyAccountPage2;

import com.zalando.GenericUtility.ExcelUtility;
import com.zalando.GenericUtility.FileUtility;
import com.zalando.GenericUtility.IConstantPath;
import com.zalando.GenericUtility.WebDriverUtility;

public class Automate2TcByMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriverUtility wu = new WebDriverUtility();
		FileUtility fu = new FileUtility();
		ExcelUtility exe = new ExcelUtility();
		fu.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		exe.OpenExcel(IConstantPath.EXCE_PATH);
		String browser = fu.getDataFromPropertyFile("browser");
		WebDriver driver = wu.openBrowserwithApplication(browser, 10,
				"http://rmgtestingserver/domain/Online_Shopping_Application/");
		CommonPage commnpge = new CommonPage(driver);
		commnpge.MyAccountClick();
		MyAccountPage2 myacc = new MyAccountPage2();
	    Map<String, String> data = exe.getDataFromExcelByMap("second");
		System.out.println(data);
		myacc.myAccountByMap(data);
		myacc.myAccountByMap2(data);
		
	}

}
