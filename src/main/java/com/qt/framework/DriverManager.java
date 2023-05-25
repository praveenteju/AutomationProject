package com.qt.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qt.utils.CommonMethods;

public class DriverManager {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public void initiateDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + ProjectConfig.getPropertyValue("DriverPath"));
		driver.set(new ChromeDriver());
		getDriver().get(ProjectConfig.getPropertyValue("URL"));
		getDriver().manage().window().maximize();

	}

	public void closeDriver() {
		getDriver().close();
	}

	public WebDriver getDriver() {
		return driver.get();
	}
}
