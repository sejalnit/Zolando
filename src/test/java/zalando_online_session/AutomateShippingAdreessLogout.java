package zalando_online_session;

import org.testng.annotations.Test;
import org.zalando.onlineObjectRepository.AddCategoryByMap;
import org.zalando.onlineObjectRepository.AddSubCategoryByMap;
import org.zalando.onlineObjectRepository.BillingAndShipping;
import org.zalando.onlineObjectRepository.InsertProductByMap;
import org.zalando.onlineObjectRepository.ManageCategoryBymap;
import org.zalando.onlineObjectRepository.MyAccountPage2;

import com.zalando.GenericUtility.BaseClass;

public class AutomateShippingAdreessLogout extends BaseClass {
	@Test(groups = "sanity")
	public void automateaTestCase4() {

		AddCategoryByMap addcat = new AddCategoryByMap(driver);
		AddSubCategoryByMap addsubcat = new AddSubCategoryByMap(driver, web);
		InsertProductByMap bymap = new InsertProductByMap(driver);
		ManageCategoryBymap managecat = new ManageCategoryBymap(driver);
		MyAccountPage2 myacc = new MyAccountPage2();
		BillingAndShipping billshp = new BillingAndShipping();
		commnpge.Category1();
		addcat.categoryByMap(exe.getDataFromExcelByMap("first1"));
		commnpge.SubCategory();
		addsubcat.addSubCategory(exe.getDataFromExcelByMap("first1"));
		commnpge.insert();
		bymap.InserActionByMap(exe.getDataFromExcelByMap("first1"));
		commnpge.manageuser();
		commnpge.adminlogout();
		web.closeBrowser(driver);
		
		String browser = null;
		web.launchBrowser(browser);
		commnpge.UserURL();
		myacc.userLoginAction(urname, psswd);
		commnpge.userlogin();
		billshp.billingandshipping(exe.getDataFromExcelByMap("Sheet3"));
		commnpge.submitAndClick();
	}
}
