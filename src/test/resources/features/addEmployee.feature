Feature: Adding employee functionality
  Scenario: Adding employee without login details
    When enter valid credentials
    And click on login button
    And click on PIM button
    And click on add employee button
    Then enter first name and last name
    And get employee id
    And click on save button
    Then verify that employee exists in the list
