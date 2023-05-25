package com.qt.utils;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qt.framework.DriverManager;
import com.qt.framework.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;


public class CommonMethods {
	DriverManager dm=new DriverManager();

	public void takeScreenshot() {
		File targetPath = null;
		try {
			File screenshot = ((TakesScreenshot) dm.getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "//ExtentReports//" + screenshot.getName();
			targetPath = new File(path);
			FileUtils.copyFile(screenshot, targetPath);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickElement(WebElement ele) {
		try {
			ele.click();
			ExtentReport.logReport(LogStatus.INFO, "Element clicked "+ele);
		} catch (Exception e) {
			ExtentReport.logReport(LogStatus.INFO, "Element is not clicked "+e.getMessage());
		}
	}

	public void sendTextToField(WebElement ele, String value) {
		try {
			ele.sendKeys(value);
			ExtentReport.logReport(LogStatus.INFO, value+" Entered successfully");
		} catch (NoSuchElementException e) {
			ExtentReport.logReport(LogStatus.INFO, value+" Unable to enter "+e.getMessage());
			Assert.fail();
		}catch(Exception e) {
			
		}
	}

	public void selectValueFromDropdown(WebElement ele, String value) {
		try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(value);
			ExtentReport.logReport(LogStatus.INFO, value+" Selected");
		} catch (Exception e) {
			ExtentReport.logReport(LogStatus.INFO, value+" unable select "+e.getMessage());
		}
	}
	
	public void waitForPageLoad() {
		dm.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
