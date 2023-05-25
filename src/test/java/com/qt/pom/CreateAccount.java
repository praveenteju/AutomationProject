package com.qt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qt.framework.Testdata;
import com.qt.utils.CommonMethods;

public class CreateAccount {
	
	WebDriver driver;
	CommonMethods methods=new CommonMethods();
	
	@FindBy(id="usernamereg-firstName") public WebElement firstNameTxt;
	@FindBy(id="usernamereg-lastName") public WebElement lastNameTxt;
	@FindBy(id="usernamereg-userId") public WebElement mailIdTxt;
	@FindBy(id="usernamereg-password") public WebElement passwordTxt;
	@FindBy(id="usernamereg-month") public WebElement monthDropdown;
	@FindBy(id="usernamereg-day") public WebElement dateTxt;
	@FindBy(id="usernamereg-year") public WebElement yearTxt;
	@FindBy(id="reg-submit-buttonnhvm") public WebElement submitBtn;
	@FindBy(xpath="//h2[contains(text(),'Create a Yahoo')]")public WebElement createAccountlbl;
	
	public CreateAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void createYahooAccount() {
		methods.waitForPageLoad();
		methods.sendTextToField(firstNameTxt, Testdata.getData("First Name"));
		methods.sendTextToField(lastNameTxt, Testdata.getData("Last Name"));
		methods.sendTextToField(mailIdTxt, Testdata.getData("Email"));
		methods.sendTextToField(passwordTxt, Testdata.getData("Password"));
		methods.selectValueFromDropdown(monthDropdown, Testdata.getData("Month"));
		methods.sendTextToField(dateTxt, Testdata.getData("Day"));
		methods.sendTextToField(yearTxt, Testdata.getData("Year"));
		
	}
	
	public void clickSubmitBtn() {
		methods.clickElement(submitBtn);
	}
	
	public void validateCreateAccountPage() {
		if(createAccountlbl.getText().contains("Create a Yahoo")) {
			System.out.println("Validates");
		}else {
			System.out.println("Not validated");
		}
	}

}
