package com.zalando.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplememntataion  implements IRetryAnalyzer{
int count=0;
int maxretry=4;
	@Override
	public boolean retry(ITestResult arg0) {
		if (count<maxretry) {
			count++;
			return true;
		}
		return false;
	}

}
