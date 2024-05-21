Feature: HomePage Functionality for OpenCart E-commerce Website


  Background:
    Given I am on the OpenCart login page
    And I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario: Verify home page title
    When navigate to search section
    And enter some text in search area
    Then search operation should be successfull

