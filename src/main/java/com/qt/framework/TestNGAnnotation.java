package com.qt.framework;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestNGAnnotation {
	
	DriverManager driver=new DriverManager();
	
	@BeforeSuite
	public static void beforeSuite(ITestContext ctx) {
		String suiteName=ctx.getCurrentXmlTest().getName();
		ExtentReport.initReport(suiteName);
	}
	
	@AfterSuite
	public static void afterSuite(ITestContext ctx) {
		ExtentReport.endReport();
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method methodName) {
		driver.initiateDriver();
		ExtentReport.initParent(methodName.toString());
	}

	
	@AfterMethod
	public void closeBrowser() {
		driver.closeDriver();
		ExtentReport.endTest();
	}
}
