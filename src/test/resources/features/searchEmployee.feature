Feature: Search Employee functionality
  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM button
    When click on employee list

  @searchEmployeeByID
  Scenario Outline: Searching multiple employees by id
    When enter "<EmployeeId>"
    And click on search button
    Then verify "<EmployeeId>" exists in the list

    Examples:
        |EmployeeId|
        |12643     |
        |12627     |
        |12594     |
        |12615     |
        |12592     |

  @searchEmployeeByFullName
  Scenario Outline: Searching multiple employees by firstName and lastName
    When enter "<FirstName>" and "<LastName>"
    And click on search button
    Then verify "<FirstName>" and "<LastName>" exist in the list

      Examples:
          |FirstName|LastName|
          |Thor     |Potter  |
          |Miguel   |Castro  |
          |Yulia    |Navalnaya|
          |Tomris   |Qazanfar|
          |Maria    |Ramirez |

  @jobTitle @regression
  Scenario: Search Employee by job title
    When search for all job titles
    Then get all job titles from db
    And verify job title data from db and ui is matched

