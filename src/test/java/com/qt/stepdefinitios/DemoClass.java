package com.qt.stepdefinitios;

import org.junit.Assert;

import com.qt.framework.DriverManager;
import com.qt.framework.Testdata;
import com.qt.pom.CreateAccount;
import com.qt.pom.LoginPage;
import com.qt.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoClass {
	DriverManager dm = new DriverManager();
	CommonMethods methods = new CommonMethods();
	LoginPage login;
	CreateAccount account;

	@Given("I launch the yahoo application {string}")
	public void i_launch_the_yahoo_application(String testcaseID) {
		Testdata.readTestdata(testcaseID);
		dm.initiateDriver();
		Hooks.scenario.log("Driver launched");
		methods.takeScreenshot();
	}

	@When("I clik on create account")
	public void i_clik_on_create_account() {
		login=new LoginPage(dm.getDriver());
		login.clickCreateAccount();
	}

	@When("I can see create account Page")
	public void i_can_see_create_account_page() {
		account=new CreateAccount(dm.getDriver());
		account.validateCreateAccountPage();
		methods.takeScreenshot();
	}

	@When("I enter all the fields")
	public void i_enter_all_the_fields() {
		account=new CreateAccount(dm.getDriver());
		account.createYahooAccount();
	}

	@When("Click on Submit")
	public void click_on_submit() {
		account=new CreateAccount(dm.getDriver());
	    account.clickSubmitBtn();
	    Assert.fail("");
	}

	@Then("account is created")
	public void account_is_created() {
	    System.out.print("Account is cretaed");
	    methods.takeScreenshot();
	}
}
