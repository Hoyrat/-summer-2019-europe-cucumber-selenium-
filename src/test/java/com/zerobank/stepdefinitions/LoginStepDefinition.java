package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @When("the user enter the valid credentials")
    public void the_user_enter_the_valid_credentials() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username,password);
    }
    @Then("the user should be on {string} page")
    public void the_user_should_be_on_page(String expectedTitle) {
        BrowserUtils.waitFor(3);
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertTrue("Actual title: " + Driver.get().getTitle(),Driver.get().getTitle().contains(expectedTitle));
    }
    @When("the user tries to login with invalid credentials")
    public void the_user_tries_to_login_with_invalid_credentials() {
        LoginPage loginPage = new LoginPage();
        String username = "abc";
        String password = "123";
        loginPage.login(username,password);
    }
    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedErrorMessage) {
        BrowserUtils.waitFor(3);
        LoginPage loginPage = new LoginPage();
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Verify that error message is displayed",expectedErrorMessage,actualErrorMessage);
    }
    @When("the user tries to login with no username or password")
    public void the_user_tries_to_login_with_no_username_or_password() {
        LoginPage loginPage = new LoginPage();
        loginPage.signIn.click();
    }
}




