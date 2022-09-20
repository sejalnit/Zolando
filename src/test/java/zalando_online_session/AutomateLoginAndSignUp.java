package zalando_online_session;

import org.testng.annotations.Test;
import org.zalando.onlineObjectRepository.MyAccountPage2;

import com.zalando.GenericUtility.BaseClass;

public class AutomateLoginAndSignUp extends BaseClass {

	@Test
	public void automte2bytest() {
		commnpge.MyAccountClick();
		MyAccountPage2 myacc = new MyAccountPage2();

		myacc.myAccountByMap(exe.getDataFromExcelByMap("second"));
		myacc.myAccountByMap2(exe.getDataFromExcelByMap("second"));
		commnpge.userlogout();
	}
}
