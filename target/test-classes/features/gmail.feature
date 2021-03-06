Feature: gmail feature

  Scenario Outline: gmail login
    Given user navigate to google application
    When user clicks on gmail link
    Then user navigate to gmail application
    And user clicks on sign in
    And user enters username "<username>"
    And user enters password "<password>"

        Examples:
        |username     |password|
        |john@test.com|test123 |
        |john@test.com|test123 |
        |john@test.com|test123 |
        |john@test.com|test123 |
