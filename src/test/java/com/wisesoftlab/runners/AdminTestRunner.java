package com.wisesoftlab.runners;

import com.wisesoftlab.admin.pages.LoginPage;
import com.wisesoftlab.utils.ConfigReader;
import com.wisesoftlab.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.wisesoftlab.utils.TestListeners.class)
public class AdminTestRunner {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("admin_url"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testAdminLogin() {
        loginPage.setEmail(ConfigReader.getProperty("admin_username"));
        loginPage.setPassword(ConfigReader.getProperty("admin_password"));
        loginPage.clickLogin();
        // Add assertions to validate the user is redirected
//        Assert.assertTrue(driver.getTitle().contains("Online Language School"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}