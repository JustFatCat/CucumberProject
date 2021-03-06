Feature: Job Titles Functionality
  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed

  Scenario: Check if job titles from UI and Db are matched
    And click on Admin button
    When click on Job Title button
    And get all the job titles from UI
    And get all the job titles from DB
    Then verify that job titles from UI and from DB are matched
