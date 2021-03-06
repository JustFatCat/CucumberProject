$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/apiWorkflow.feature");
formatter.feature({
  "name": "Syntax HRMS API Workflow",
  "description": "    Description: This feature tests Syntax HRMS API WorkFlow",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateToken.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a POST call is made to create an Employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_POST_call_is_made_to_create_an_Employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for creating an Employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_for_creating_an_Employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Employee is created contains key \"Message\" and value \"Entry Created\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_Employee_is_created_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the EmployeeID \"Employee[0].employee_id\" is stored in global variable to be used for other calls",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_EmployeeID_is_stored_in_global_variable_to_be_used_for_other_calls(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateToken.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieving the created Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    },
    {
      "name": "@progression"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to retrieve the created employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_retrieve_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrieve the created Employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_GET_call_is_made_to_retrieve_the_created_Employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for retrieving Employee is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_for_retrieving_Employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved EmployeeID \"employee[0].employee_id\" matches the globally stored EmployeeID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved data at \"employee\" matches the data used to create Employee with employee ID \"employee[0].employee_id\"",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_data_at_matches_the_data_used_to_create_Employee_with_employee_ID(java.lang.String,java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateToken.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update the created Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to update the created employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_update_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a PUT call is made to update the created Employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_PUT_call_is_made_to_update_the_created_Employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for updating Employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_for_updating_Employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the updated Employee contains key \"Message\" and value \"Entry updated\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_updated_Employee_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateToken.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieving the updated Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to retrieve the updated employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_retrieve_the_updated_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrieve the updated Employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_GET_call_is_made_to_retrieve_the_updated_Employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for retrieving the updated Employee is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_for_retrieving_the_updated_Employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved Employee_Middle_Name \"employee[0].emp_middle_name\" matches the updated_middle_name",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_Employee_Middle_Name_matches_the_updated_middle_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateToken.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Partially update Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to partially update the employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_partially_update_the_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "PATCH call is made to partially update the employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.patch_call_is_made_to_partially_update_the_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for partially updating Employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_for_partially_updating_Employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the partially updated Employee contains key \"Message\" and value \"Entry updated\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_partially_updated_Employee_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the partially update Employee \"employee[0].emp_firstname\" matches the the globally stored emp_firstname",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_partially_update_Employee_matches_the_the_globally_stored_emp_firstname(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateToken.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete the created Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to delete the employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_delete_the_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a DELETE call is made to delete the employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_DELETE_call_is_made_to_delete_the_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is successfully deleted with \"message\" in response \"Entry deleted\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_employee_is_successfully_deleted_with_in_response(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"employee[0].employee_id\" is same as the one stored in global",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_is_same_as_the_one_stored_in_global(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateToken.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Get all Employees",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to get all employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_get_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET call is made to retrieve all employees",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.get_call_is_made_to_retrieve_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code of the request is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_of_the_request_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "it contains key1 \"Total Employees\" and key2 \"Employees\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.it_contains_key1_and_key2(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateToken.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieve all Employees status",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to get all employees statuses",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_get_all_employees_statuses()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrieve the statuses of all employees",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_GET_call_is_made_to_retrieve_the_statuses_of_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code of the request is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_of_the_request_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "it contains value1 \"Employee\" and value2 \"Worker\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.it_contains_value1_and_value2(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});