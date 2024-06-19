package com.wisesoftlab.utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private static WebDriver driver;

    @Before("@Admin")
    public void setUpAdmin() {
        driver = DriverFactory.getDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("admin_url"));
    }

    @Before("@Portal")
    public void setUpPortal() {
        driver = DriverFactory.getDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("portal_url"));
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot(driver, scenario.getName());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}