package com.qt.framework;

import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	private static ExtentReports extentParent;
	private static ExtentTest extentTest;
	
	static ThreadLocal<ExtentTest> test=new ThreadLocal<>();

	public static void initReport(String suiteName) {
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_") + ".html";
		extentParent = new ExtentReports(System.getProperty("user.dir") + "//Reports//" + filename+suiteName);
	}

	public static void logReport(LogStatus logStatus, String stepName) {
		test.get().log(logStatus, stepName);
		try {
			switch (logStatus) {
			case PASS:
			case FAIL:
			case WARNING:
			case INFO:
			case SKIP:
				test.get().log(logStatus, stepName);
				break;
			case ERROR:
				test.get().log(LogStatus.FAIL, stepName);
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initParent(String Testname) {
		test.set(extentParent.startTest(Testname));
	}
	
	public static void endTest() {
		extentParent.endTest(extentTest);
	}
	
	public static void endReport() {
		extentParent.flush();
		extentParent.close();
	}

}