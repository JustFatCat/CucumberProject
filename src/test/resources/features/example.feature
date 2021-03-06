Feature: Login Functionality
  @validCreds #scenario level tag
  Scenario: Login with valid credentials
#    Given navigate to HRMS login page
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
#    And quite the browser
