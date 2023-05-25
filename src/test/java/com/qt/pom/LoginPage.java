	package com.qt.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qt.utils.CommonMethods;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "createacc") public WebElement createAccountBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateAccount() {
		CommonMethods methods=new CommonMethods();
		methods.clickElement(createAccountBtn);
	}

}
