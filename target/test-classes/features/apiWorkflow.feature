#author: Natalia

  @apiWorkflow
  Feature: Syntax HRMS API Workflow
    Description: This feature tests Syntax HRMS API WorkFlow
  Background:
    Given a JWT is generated

    Scenario: Creating an Employee
      Given a request is prepared to create an employee
      When a POST call is made to create an Employee
      Then the status code for creating an Employee is 201
      And the Employee is created contains key "Message" and value "Entry Created"
      And the EmployeeID "Employee[0].employee_id" is stored in global variable to be used for other calls

    @progression
    Scenario: Retrieving the created Employee
      Given a request is prepared to retrieve the created employee
      When a GET call is made to retrieve the created Employee
      Then the status code for retrieving Employee is 200
      And the retrieved EmployeeID "employee[0].employee_id" matches the globally stored EmployeeID
      And the retrieved data at "employee" matches the data used to create Employee with employee ID "employee[0].employee_id"
        |emp_firstname| emp_middle_name|emp_lastname|emp_birthday|emp_gender|emp_job_title|emp_status|
        |    Soguffg  | s              |  sadiqiouiu| 2021-02-27 |    Male  |Cloud Architect|Employee|

    Scenario: Update the created Employee
      Given a request is prepared to update the created employee
      When a PUT call is made to update the created Employee
      Then the status code for updating Employee is 201
      And the updated Employee contains key "Message" and value "Entry updated"

    Scenario: Retrieving the updated Employee
      Given a request is prepared to retrieve the updated employee
      When a GET call is made to retrieve the updated Employee
      Then the status code for retrieving the updated Employee is 200
      And the retrieved Employee_Middle_Name "employee[0].emp_middle_name" matches the updated_middle_name

    Scenario: Partially update Employee
      Given a request is prepared to partially update the employee
      When PATCH call is made to partially update the employee
      Then the status code for partially updating Employee is 201
      And the partially updated Employee contains key "Message" and value "Entry updated"
      And the partially update Employee "employee[0].emp_firstname" matches the the globally stored emp_firstname

    Scenario: Delete the created Employee
      Given a request is prepared to delete the employee
      When a DELETE call is made to delete the employee
      Then the status code is 201
      And the employee is successfully deleted with "message" in response "Entry deleted"
      And the "employee[0].employee_id" is same as the one stored in global

    Scenario: Get all Employees
      Given a request is prepared to get all employees
      When GET call is made to retrieve all employees
      Then the status code of the request is 200
      And it contains key1 "Total Employees" and key2 "Employees"

    Scenario: Retrieve all Employees status
      Given a request is prepared to get all employees statuses
      When a GET call is made to retrieve the statuses of all employees
      Then the status code of the request is 200
      And it contains value1 "Employee" and value2 "Worker"




