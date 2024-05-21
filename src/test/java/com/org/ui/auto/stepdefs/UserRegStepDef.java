package com.org.ui.auto.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class UserRegStepDef {

    @Given("User is on registration page")
    public void user_is_on_registration_page() {
        System.out.println("user naviagtes to registration page");
    }
    @When("User enter following user details")
    public void user_enter_following_user_details(DataTable dataTable) {
        List< List<String>> userList =dataTable.asLists(String.class);

        userList.forEach((a)->System.out.println(a));
    }

    @When("User enter following user details with columns")
    public void user_enter_following_user_details_with_columns(DataTable dataTable) {
        List<Map<String,String>> userMap=dataTable.asMaps(String.class,String.class);

        System.out.println(userMap);
        for(Map<String,String> a: userMap){
            System.out.println(a.get("firstname"));
            System.out.println(a.get("lastname"));
            System.out.println(a.get("email"));
            System.out.println(a.get("phone"));
            System.out.println(a.get("city"));
        }
    }
    @Then("user  registration should be successful")
    public void user_registration_should_be_successful() {
        System.out.println("user registration should be successfull");
    }

}
