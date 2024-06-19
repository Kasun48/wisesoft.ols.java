package com.wisesoftlab.portal.stepdefinitions;

import com.wisesoftlab.portal.pages.PortalLoginPage;
import com.wisesoftlab.utils.ConfigReader;
import com.wisesoftlab.utils.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class PortalLoginSteps {
    WebDriver driver = Hooks.getDriver();
    PortalLoginPage loginPage = new PortalLoginPage(driver);

    @Given("Portal user is on the login page")
    public void portal_user_is_on_the_login_page() {
        driver.get(ConfigReader.getProperty("portal_url"));
    }

    @When("Portal user enters credentials")
    public void portal_user_enters_credentials() {
        loginPage.setUsername(ConfigReader.getProperty("portal_username"));
        loginPage.setPassword(ConfigReader.getProperty("portal_password"));
    }

    @And("Portal user clicks on login button")
    public void portal_user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("Portal user should be redirected to the dashboard")
    public void portal_user_should_be_redirected_to_the_dashboard() {
        // Add assertions to validate the user is redirected
    }
}