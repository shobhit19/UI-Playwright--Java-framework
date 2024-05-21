package com.org.ui.auto.stepdefs;

import com.org.ui.auto.pages.HomePage;
import com.org.ui.auto.drivermanager.PlaywrightThreadLocalPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.org.ui.auto.pages.LoginPage;

public class LoginPageStepDef   {

    LoginPage loginPage = new LoginPage(PlaywrightThreadLocalPage.getPage());
    HomePage homePage;
    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        Assert.assertEquals(loginPage.getPageTitle(PlaywrightThreadLocalPage.getPage()),"Account Login");
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterCredentials("p.t@gmail.com","test@123");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        homePage=loginPage.clickOnLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
            Assert.assertEquals(loginPage.getPageTitle(PlaywrightThreadLocalPage.getPage()),"My Account");
    }
    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterCredentials(username,password);
    }
    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMsg) {
       Assert.assertEquals( loginPage.getErrorMessage().trim(),errorMsg);
    }

}
