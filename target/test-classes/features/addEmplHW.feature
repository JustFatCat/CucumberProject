Feature: Add Employee Functionality

  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM button
    And click on add employee button

  @addEmployeeWithoutLogin
  Scenario: Add employee without login details
    Then enter first name and last name
    And click on save button
    Then verify employee is added successfully

  #@addEmployeeWithLogin
  #Scenario: Add employee with login details and middle name
    #Then enter first name and last name and middle name
    #When click on login details checkbox
    #Then enter login details
    #And click on save button
    #Then verify employee is added successfully

  @parameter
  Scenario: Add employee without login details but with middle name
    Then enter first name "Marta123", middle name "Mary123" and last name "Ostash123"
    And click on save button
    Then verify that "Marta123 Mary123 Ostash123" is added successfully

  @examples
  Scenario Outline: Adding multiple employees without login details
    When enter "<FirstName>", "<MiddleName>" and "<LastName>"
    And click on save button
    Then verify "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

      Examples:
          |FirstName|MiddleName|LastName|
          |Mark     |J         |Smith   |
          |John     |K         |Wick    |
  @dataTableWithHeader
  Scenario: Adding multiple employees at one execution
    When add multiple employees and verify they are added successfully
      |FirstName|MiddleName|LastName|EmployeeId|
      |Jack     |J         |Toronto |111161911|
      |David    |K         |Wick    |122223449|
  @excelTask
  Scenario: Adding multiple employees from excel
    When add multiple employees from excel "AddEmployee" sheet and verify they are added

  @db @regression
  Scenario: Adding Employee and database validation
    When enter first name "John1", middle name "John1" and last name "Doe1"
    And capture employeeId
    And click on save button
    Then collect employee data from hrms database
    And verify data from db and ui is matched



