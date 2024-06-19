package com.wisesoftlab.admin.stepdefinitions;

import com.wisesoftlab.admin.pages.LoginPage;
import com.wisesoftlab.utils.ConfigReader;
import com.wisesoftlab.utils.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("Admin user is on the login page")
    public void admin_user_is_on_the_login_page() {
        driver.get(ConfigReader.getProperty("admin_url"));
    }

    @When("Admin user enters credentials")
    public void admin_user_enters_credentials() {
        loginPage.setEmail(ConfigReader.getProperty("admin_username"));
        loginPage.setPassword(ConfigReader.getProperty("admin_password"));
    }

    @And("Admin user clicks on login button")
    public void admin_user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("Admin user should be redirected to the dashboard")
    public void admin_user_should_be_redirected_to_the_dashboard() {
        // Add assertions to validate the user is redirected
    }
}