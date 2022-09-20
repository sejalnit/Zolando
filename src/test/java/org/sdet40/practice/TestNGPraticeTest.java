package org.sdet40.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPraticeTest {
	
	
	@BeforeSuite
	public void beforesuite() {
	System.out.println("before suite execute");
	}
    @BeforeTest
	public void beforeTest() {
	System.out.println("before Test execute");
	}
    @BeforeClass
	public void beforeclass() {
	System.out.println("before class execute");
	}
    @BeforeMethod
	public void beforeMethod() {
	System.out.println("before method execute");
	}

    @Test
    public void testmthod1() {
    	System.out.println("test execution happen here");
    }
    
    @Test
    public void testmthod2() {
    	System.out.println("test execute already");
    	
    }
    
    
    @AfterSuite
	public void afterSuite() {
	System.out.println("After suite execute");
	}
    @AfterTest
	public void afterTest() {
	System.out.println("@After Test execute");
	}
    @AfterClass
	public void afterclass() {
	System.out.println("After class execute");
	}
    @AfterMethod
	public void afterMethod() {
	System.out.println("After method execute");
	}
    
    
    
    
    
    
    
    
    
}
