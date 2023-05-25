package com.qt.stepdefinitios;


import org.testng.annotations.Test;

import com.qt.framework.DriverManager;
import com.qt.framework.ExtentReport;
import com.qt.framework.TestNGAnnotation;
import com.qt.pom.CreateAccount;
import com.qt.pom.LoginPage;

public class TestCases extends TestNGAnnotation{

	DriverManager dm = new DriverManager();
	LoginPage login;
	CreateAccount account;
	ExtentReport report = new ExtentReport();
	
	@Test(groups = "ParameterConcept")
	public void CreateAccount() {

		login = new LoginPage(dm.getDriver());
		login.clickCreateAccount();

	}
	
	@Test(groups = "ParameterConcept")
	public void CreateAccount1() {

		login = new LoginPage(dm.getDriver());
		login.clickCreateAccount();

	}


}
