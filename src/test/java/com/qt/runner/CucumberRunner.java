package com.qt.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "FeatureFiles",
		glue = {"com.qt.stepdefinitios"},
		tags = "@Sanity",
		monochrome = true,
		plugin = {"pretty","html:Reports/CucumberReport.html"}
		)

public class CucumberRunner {

}
              