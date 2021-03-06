#autor: natalis200623@gmail.com
@search @sprint5
Feature: Search feature/functionality
  Background:
    When user enters any text

  @smokeTest
  Scenario: search by typing and hit enter
    #Given user navigate to google application
    And hits enter
    Then result is displayed

  @regression
  Scenario: search by typing and using google search button
    #Given user navigate to google application
    And clicks on google search button
    Then result is displayed