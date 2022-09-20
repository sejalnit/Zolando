package org.sdet40.practice;

import org.testng.annotations.Test;

import com.zalando.GenericUtility.WebDriverUtility;

public class MavenPracticeTest {
	@Test
	public void step1()
	{
		String browser=System.getProperty("b");
		String url= System.getProperty("u");
		System.out.println("browser name is-->>>" +browser);
		System.out.println("url name is --->>>" +url);
		 
		WebDriverUtility web=new WebDriverUtility();
		web.openBrowserwithApplication(browser, 10, url);
		
	}
}