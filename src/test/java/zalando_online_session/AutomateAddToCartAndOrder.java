package zalando_online_session;

import org.testng.annotations.Test;
import org.zalando.onlineObjectRepository.MyAccountPage2;
import org.zalando.onlineObjectRepository.SearchProduct;

import com.zalando.GenericUtility.BaseClass;

public class AutomateAddToCartAndOrder extends BaseClass{
@Test(groups ="sanity")
public void automateaTestCase3() {
	
	 MyAccountPage2 myacc=new MyAccountPage2();
	 SearchProduct search=new SearchProduct();
	 // passEnterKey pk=new  passEnterKey();
	 
	 commnpge.MyAccountClick();
	 myacc.myAccountByMap2(exe.getDataFromExcelByMap("second"));
	 search.searchBYproduct(exe.getDataFromExcelByMap("first1"));
   

}
}