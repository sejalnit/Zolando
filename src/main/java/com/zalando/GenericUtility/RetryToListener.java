package com.zalando.GenericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryToListener  implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testclass, Constructor testConstructor, Method testMethod ) {
		annotation.setRetryAnalyzer(com.zalando.GenericUtility.ListenerImplementation.class);
		
		
	}

	
}
