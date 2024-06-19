package com.wisesoftlab.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.wisesoftlab.admin.stepdefinitions", "com.wisesoftlab.portal.stepdefinitions", "com.wisesoftlab.utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {}