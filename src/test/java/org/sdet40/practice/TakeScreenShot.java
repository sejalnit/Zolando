package org.sdet40.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zalando.GenericUtility.BaseClass;
import com.zalando.GenericUtility.JavaUtility;
import com.zalando.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShot extends BaseClass {

	@Test
	public void ScreenShot() {
		WebDriverManager.chromedriver().setup();
	
		WebDriverUtility web =new WebDriverUtility();
		web.navigateTheApllication(driver, "http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		JavaUtility java=new JavaUtility();
		java.currentTime();
		web.takeScreenshot(driver, "TakeScreenShot", java);
		Assert.fail();
		
}
}