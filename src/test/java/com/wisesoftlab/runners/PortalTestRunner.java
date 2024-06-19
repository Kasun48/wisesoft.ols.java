package com.wisesoftlab.runners;

import com.wisesoftlab.portal.pages.PortalLoginPage;
import com.wisesoftlab.utils.ConfigReader;
import com.wisesoftlab.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

@Listeners(com.wisesoftlab.utils.TestListeners.class)
public class PortalTestRunner {
    WebDriver driver;
    PortalLoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("portal_url"));
        loginPage = new PortalLoginPage(driver);
    }

    @Test
    public void testPortalLogin() {
        loginPage.setUsername(ConfigReader.getProperty("portal_username"));
        loginPage.setPassword(ConfigReader.getProperty("portal_password"));
        loginPage.clickLogin();
        // Add assertions to validate the user is redirected
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}