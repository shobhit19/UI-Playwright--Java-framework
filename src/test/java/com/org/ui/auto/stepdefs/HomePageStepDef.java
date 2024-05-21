package com.org.ui.auto.stepdefs;

import com.org.ui.auto.drivermanager.PlaywrightThreadLocalPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.org.ui.auto.pages.HomePage;

public class HomePageStepDef {

    HomePage homePage = new HomePage(PlaywrightThreadLocalPage.getPage());


    @Given("I am on the home page of open e cart")
    public void i_am_on_the_home_page_of_open_e_cart() {
        Assert.assertEquals(homePage.getHomePageTitle(PlaywrightThreadLocalPage.getPage()),"Account Login");

    }
    @Then("verify the title of the page")
    public void verify_the_title_of_the_page() {
        Assert.assertEquals(homePage.getHomePageTitle(PlaywrightThreadLocalPage.getPage()),"Account Login");
    }
    @When("navigate to search section")
    public void navigate_to_search_section() {
        homePage.clickOnSearchSection();
    }
    @When("enter some text in search area")
    public void enter_some_text_in_search_area() {
        homePage.enterTextInSearchSection("apple");
        homePage.clickOnSearchIcon(PlaywrightThreadLocalPage.getPage());
    }
    @Then("search operation should be successfull")
    public void search_operation_should_be_successfull() {
       Assert.assertEquals(homePage.getSearchedText(PlaywrightThreadLocalPage.getPage()),"Search - apple");
    }

}
