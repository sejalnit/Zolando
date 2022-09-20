package zalando_online_session;

import org.testng.annotations.Test;
import org.zalando.onlineObjectRepository.AddCategoryByMap;
import org.zalando.onlineObjectRepository.AddSubCategoryByMap;
import org.zalando.onlineObjectRepository.InsertProductByMap;
import com.zalando.GenericUtility.BaseClass;

public class AutomateCreateandSubcategory extends BaseClass {
	
	@Test(groups ="sanity")
	public void automateaTestCase1() {
		
		AddCategoryByMap addcat = new AddCategoryByMap(driver);
		AddSubCategoryByMap addsubcat = new AddSubCategoryByMap(driver, web);
		InsertProductByMap bymap= new InsertProductByMap(driver);
		commnpge.Category1();
		addcat.categoryByMap(exe.getDataFromExcelByMap("first1"));
		commnpge.SubCategory();
		addsubcat.addSubCategory(exe.getDataFromExcelByMap("first1"));
		commnpge.insert();
		bymap.InserActionByMap(exe.getDataFromExcelByMap("first1"));
	    commnpge.manageuser();
	    commnpge.adminlogout();
		web.closeBrowser(driver);
	}
}


		
	

