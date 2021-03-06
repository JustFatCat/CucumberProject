@featureTag @login #feature level tag
Feature: Login Functionality
  @validCreds #scenario level tag
  Scenario: Login with valid credentials
#    Given navigate to HRMS login page
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
#    And quite the browser

  @smoke @syntax @whatever #adding multiple tags
  Scenario: Login with invalid credentials
#    Given navigate to HRMS login page
    When enter invalid credentials
    And click on login button
    Then verify error message
#    And quite the browser

  Scenario:
#    Given navigate to HRMS login page
    When enter empty username and valid password
    And click on login button
    Then verify empty username error message
#    And quite the browser

  @test
  Scenario:
    Given navigate to HRMS login page
    When enter valid username and empty password
    And click on login button
    Then verify empty password error message
    And quite the browser
