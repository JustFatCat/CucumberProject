package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods {
    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
        setUp();
    }

    @When("enter valid credentials")
    public void enter_valid_credentials() {
        loginPage.login("Admin", "Hum@nhrm123");
    }

    @When("click on login button")
    public void click_on_login_button() {
        loginPage.clickOnLoginBtn();
    }

    @Then("verify dashboard is displayed")
    public void verify_dashboard_is_displayed() {
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
    }

    @Then("quite the browser")
    public void quite_the_browser() {
        tearDown();
    }

    @When("enter invalid credentials")
    public void enter_invalid_credentials() {
        loginPage.login("Admin232", "Hum@nhrm12389");
    }

    @When("verify error message")
    public void verify_error_message() {
        Assert.assertEquals("Verifying error message", "Invalid credentials", loginPage.getErrorMessageText());
    }

    @When("enter empty username and valid password")
    public void enter_empty_username_and_valid_password() {
        loginPage.login("", "Hum@nhrm123");
    }

    @Then("verify empty username error message")
    public void verify_empty_username_error_message() {
        Assert.assertEquals("Verifying empty username message", "Username cannot be empty", loginPage.getErrorMessageText());
    }

    @When("enter valid username and empty password")
    public void enter_valid_username_and_empty_password() {
        loginPage.login("Admin", "");
    }

    @Then("verify empty password error message")
    public void verify_empty_password_error_message() {
        Assert.assertEquals("Verifying empty password message", "Password cannot be empty", loginPage.getErrorMessageText());
    }

}
