package com.zalando.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	private ExtentReports reports;
	public static ExtentTest stest;
	private ExtentTest test;

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		ExtentSparkReporter spark=new ExtentSparkReporter("");
		spark.config().setDocumentTitle("documentTitle SDET40");
		spark.config().setReportName("Report name SDET 40");
		spark.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("author", "sejal");
		reports.setSystemInfo("OS", "win 8");
		reports.setSystemInfo("browser","chrome");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"fail");
		System.out.println(Thread.currentThread().getId());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test1 skip");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
	test=reports.createTest(result.getMethod().getMethodName());
			stest=test;
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	test.pass(result.getMethod().getMethodName()+"pass");
		
	}

}
