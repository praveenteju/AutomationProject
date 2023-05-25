package com.qt.stepdefinitios;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	static Scenario scenario;
	
	@Before
	public void initReport(Scenario scenario) {
		Hooks.scenario=scenario;
	}
	
	@After
	public void endReport() {
		if(scenario.isFailed()) {
			scenario.log("Scenario Failed");
		}
	}

}
