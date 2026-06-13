package com.vtiger.stepdefinations;

import com.vtiger.pages.homepage;
import com.vtiger.pages.loginpage;
import com.vtiger.utilities.commonMethods;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class loginSteps extends commonMethods {

    loginpage lp = new loginpage();
    homepage hp = new homepage();

    @Given("user should be on login page")
    public void user_should_be_on_login_page() {

        Assert.assertTrue(lp.isLoginPageDisplayed());
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {

        System.out.println("Userid = " + prop.getProperty("userid"));
        System.out.println("Password = " + prop.getProperty("password"));

        lp.enterUsername(prop.getProperty("userid"));
        lp.enterPassword(prop.getProperty("password"));
    }

    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials() {

        lp.enterUsername("admin123");
        lp.enterPassword("admin123");
    }

    @When("user enters invalid credentials username as {string} and password as {string}")
    public void user_enters_invalid_credentials_username_as_and_password_as(
            String userid,
            String password) {

        lp.enterUsername(userid);
        lp.enterPassword(password);
    }

    @And("click on login button")
    public void click_on_login_button() {

        lp.clickLogin();
    }

    @Then("user should be navigated to home page")
    public void user_should_be_navigated_to_home_page() {

        Assert.assertTrue(hp.isHomePageDisplayed());
    }

    @And("user can see the logout link")
    public void user_can_see_the_logout_link() {

        Assert.assertTrue(hp.isLogoutLinkDisplayed());
    }

    @Then("user should be navigated to login page")
    public void user_should_be_navigated_to_login_page() {

        Assert.assertTrue(lp.isLoginPageDisplayed());
    }

    @And("user can see the error message")
    public void user_can_see_the_error_message() {

        Assert.assertFalse(lp.getErrorMessage().isEmpty());
    }
}