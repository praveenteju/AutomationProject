package com.qt.framework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviders {
	
	
	@DataProvider(name="testData_Privider")
	public Object [][]dpMethod(){
		return new Object[][] {{"Test"},{"testing"},{"Tester"}};
	}
	
	@Test(dataProvider = "testData_Privider")
	public void newtest(String val) {
		
		System.out.println(val);
	}

}
