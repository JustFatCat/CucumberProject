package com.hrms.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.apiCommonMethods;
import com.hrms.utils.apiConstants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class apiTestingFinalSteps extends apiCommonMethods {
    RequestSpecification request;
    Response response;
    static String employeeID;
    static String updated_employee_middle_name;
    static String partiallyUpdated_first_name;
    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        //preparing request to create employee
        request = apiCommonMethods.createEmployeeRequest(generateToken.token, CommonMethods.readJson(apiConstants.CREATE_EMPLOYEE_JSON));

        /*File input = new File("/home/nicholas/eclipse-workspace/CucumberFramework/src/test/resources/JsonData/createUser.json");
        JsonObject createUserData = null;
        try {*/
            //parsing the input file
            /*JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            createUserData = fileElement.getAsJsonObject();
            //Access key message
            JsonElement employee = createUserData.get("Employee");
            JsonArray employee_details = employee.getAsJsonArray();
            JsonElement employee1_details = employee_details.get(0);
            JsonObject employee1_object = employee1_details.getAsJsonObject();

            System.out.println("Employee1 details " + employee1_object);
            System.out.println(employee1_object.get("emp_firstname"));*/

            //Get emp_birthday
            /*JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            createUserData = fileElement.getAsJsonObject();
            JsonElement employee = createUserData.get("Employee");
            JsonArray employee_details = employee.getAsJsonArray();
            JsonElement employee1_details = employee_details.get(0);
            JsonObject employee1_object = employee1_details.getAsJsonObject();

            System.out.println(employee1_object.get("emp_birthday"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }
    @When("a POST call is made to create an Employee")
    public void a_POST_call_is_made_to_create_an_Employee() {
        //sending the request to create employee
        response = request.when().post(apiConstants.CREATE_EMPLOYEE_URI);
    }
    @Then("the status code for creating an Employee is {int}")
    public void the_status_code_for_creating_an_Employee_is(int statusCode) {
        //assert that status code is 201
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("the Employee is created")
    public void the_Employee_is_created() {
        //assert that the message contains Entry Created
        response.then().assertThat().body("Message", equalTo("Entry Created"));
    }
    @Then("the Employee is created contains key {string} and value {string}")
    public void the_Employee_is_created_contains_key_and_value(String key, String value) {
        response.then().assertThat().body(key, equalTo(value));
    }
    @Then("the EmployeeID is stored in global variable to be used for other calls")
    public void the_EmployeeID_is_stored_in_global_variable_to_be_used_for_other_calls() {
        //extract the employeeID from Json response
        employeeID = response.jsonPath().getString("employee[0].employee_id");
    }
    @Then("the EmployeeID {string} is stored in global variable to be used for other calls")
    public void the_EmployeeID_is_stored_in_global_variable_to_be_used_for_other_calls(String value) {
        //extract the employeeID from Json response
        employeeID = response.jsonPath().getString(value);
    }

    //------------------------------Retrieving Created Employee------------------------------------------------
    @Given("a request is prepared to retrieve the created employee")
    public void a_request_is_prepared_to_retrieve_the_created_employee() {
        //preparing the request to retrieve the created employee
        request = getOneEmployeeRequest(generateToken.token,employeeID);
    }

    @When("a GET call is made to retrieve the created Employee")
    public void a_GET_call_is_made_to_retrieve_the_created_Employee() {
        //sending request to retrieve the created employee
        response = request.when().get(apiConstants.GET_ONE_EMPLOYEE_URI);
    }
    @Then("the status code for retrieving Employee is {int}")
    public void the_status_code_for_retrieving_Employee_is(int statusCode) {
        //assert that status code is 200
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("the retrieved EmployeeID {string} matches the globally stored EmployeeID")
    public void the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID(String value) {
        response.then().assertThat().body(value, equalTo(employeeID));

    }
    @Then("the retrieved data matches the data used to create Employee")
    public void the_retrieved_data_matches_the_data_used_to_create_Employee() {
        //response.then().assertThat().body("employee[0].emp_firstname", equalTo("Soguffg"));
        //outdated step
        JsonPath jsonPath = response.jsonPath();
        String emp_first_name = jsonPath.getString("employee[0].emp_firstname");
        String emp_last_name = jsonPath.getString("employee[0].emp_lastname");
        String emp_middle_name = jsonPath.getString("employee[0].emp_middle_name");
        String emp_birthday = jsonPath.getString("employee[0].emp_birthday");
        String emp_gender = jsonPath.getString("employee[0].emp_gender");
        String emp_job_title = jsonPath.getString("employee[0].emp_job_title");
        String emp_status = jsonPath.getString("employee[0].emp_status");

        assertThat(emp_first_name, equalTo("Soguffg"));
        assertThat(emp_last_name, equalTo("sadiqiouiu"));
        assertThat(emp_middle_name, equalTo("s"));
        assertThat(emp_birthday, equalTo("2021-02-27"));
        assertThat(emp_gender, equalTo("Male"));
        assertThat(emp_job_title, equalTo("Cloud Architect"));
        assertThat(emp_status, equalTo("Employee"));
    }

    @Then("the retrieved data at {string} matches the data used to create Employee with employee ID {string}")
    public void the_retrieved_data_at_matches_the_data_used_to_create_Employee_with_employee_ID(String employeeObject, String responseEmployeeID, DataTable dataTable) {
        String body = response.asString();

        JsonElement response_json = JsonParser.parseString(body);
        JsonObject response_json_object = response_json.getAsJsonObject();
        JsonElement employee_data = response_json_object.get("employee");
        JsonArray employee_data_array = employee_data.getAsJsonArray();
        JsonElement employee_0_info = employee_data_array.get(0);
        JsonObject employee_info = employee_0_info.getAsJsonObject();
        System.out.println("The employee_firstname is " + employee_info.get("emp_firstname").toString());
        System.out.println("The employee_birthday is " + employee_info.get("emp_birthday").toString());



        /*//A map to have the data expected in the response --> from feature file
        List<Map<String,String>> expectedData = dataTable.asMaps(String.class, String.class);

        //getting data from the response body
        List<Map<String,String>> actualData = response.body().jsonPath().get(employeeObject);

        //loop through the keys in our hardcoded data and get the value
        int index = 0;
        for(Map<String,String> map: expectedData){
            Set<String> keys = map.keySet();
            //loop through keys and get their value and assert
            for (String key: keys){
                String expectedValue = map.get(key);
                String actualValue = actualData.get(index).get(key);
                Assert.assertEquals(expectedValue, actualValue);
            }
            index ++;
        }
        String empID = response.body().jsonPath().getString(responseEmployeeID);
        Assert.assertTrue(empID.contentEquals(employeeID));*/
    }

    //-----------------------Updating Employee---------------------------------------------------------------
    @Given("a request is prepared to update the created employee")
    public void a_request_is_prepared_to_update_the_created_employee() {
        updated_employee_middle_name="updated middle name";
        JSONObject payload = new JSONObject();
        payload.put("employee_id",employeeID);
        payload.put("emp_firstname","SofaKoshia");
        payload.put("emp_lastname","Gala");
        payload.put("emp_middle_name",updated_employee_middle_name);
        payload.put("emp_gender","F");
        payload.put("emp_birthday","2021-02-27");
        payload.put("emp_status","Employee");
        payload.put("emp_job_title","Cloud Architect");
        String finalPayload = payload.toString();

        request = given().header(apiConstants.header_Content_type, apiConstants.content_type)
                .header(apiConstants.header_authorization, generateToken.token)
                .body(finalPayload).log().all();
    }

    @When("a PUT call is made to update the created Employee")
    public void a_PUT_call_is_made_to_update_the_created_Employee() {
        //sending a put request to update the employee
        response = request.when().put(apiConstants.UPDATE_EMPLOYEE_URI);
    }
    @Then("the status code for updating Employee is {int}")
    public void the_status_code_for_updating_Employee_is(int status_code) {
        //asserting that status code is 200
        response.then().assertThat().statusCode(status_code);
    }
    @Then("the updated Employee contains key {string} and value {string}")
    public void the_updated_Employee_contains_key_and_value(String key, String value) {
        response.then().assertThat().body(key,equalTo(value));
    }

    //------------------------------------Retrieving update Employee-------------------------------------------
    @Given("a request is prepared to retrieve the updated employee")
    public void a_request_is_prepared_to_retrieve_the_updated_employee() {
        request = given().header(apiConstants.header_Content_type, apiConstants.content_type)
                .header(apiConstants.header_authorization, generateToken.token)
                .queryParam("employee_id", employeeID);
    }

    @When("a GET call is made to retrieve the updated Employee")
    public void a_GET_call_is_made_to_retrieve_the_updated_Employee() {
        //make a get call to retrieve the updated Employee
        response = request.when().get(apiConstants.GET_ONE_EMPLOYEE_URI);

    }
    @Then("the status code for retrieving the updated Employee is {int}")
    public void the_status_code_for_retrieving_the_updated_Employee_is(int status_code) {
        //assert the status code
        response.then().assertThat().statusCode(status_code);
    }
    @Then("the retrieved Employee_Middle_Name {string} matches the updated_middle_name")
    public void the_retrieved_Employee_Middle_Name_matches_the_updated_middle_name(String updatedMiddleName) {
        //response.then().assertThat().body(updatedMiddleName, equalTo(updated_employee_middle_name));
        String actualMiddleName = response.jsonPath().getString(updatedMiddleName);
        assertThat(actualMiddleName, equalTo(updated_employee_middle_name));

        //JUnit assert
        /*boolean verifyMiddleName = actualMiddleName.equalsIgnoreCase(updated_employee_middle_name);
        System.out.println(verifyMiddleName);
        Assert.assertTrue(verifyMiddleName);*/
    }

    //---------------------------Partially updating the Employee------------------------------
    @Given("a request is prepared to partially update the employee")
    public void a_request_is_prepared_to_partially_update_the_employee() {
        partiallyUpdated_first_name = "Updated_successfully";
        JSONObject payload = new JSONObject();
        payload.put("employee_id",employeeID);
        payload.put("emp_firstname",partiallyUpdated_first_name);
        String final_payload = payload.toString();

        request = given().header(apiConstants.header_Content_type, apiConstants.content_type)
                .header(apiConstants.header_authorization, generateToken.token)
                .body(final_payload);
    }

    @When("PATCH call is made to partially update the employee")
    public void patch_call_is_made_to_partially_update_the_employee() {
        response = request.when().patch(apiConstants.PARTIALLY_UPDATE_EMPLOYEE_URI);
    }
    @Then("the status code for partially updating Employee is {int}")
    public void the_status_code_for_partially_updating_Employee_is(int status_code) {
        response.then().assertThat().statusCode(status_code);
    }

    @Then("the partially updated Employee contains key {string} and value {string}")
    public void the_partially_updated_Employee_contains_key_and_value(String key, String value) {
        response.then().assertThat().body(key, equalTo(value));
    }

    @Then("the partially update Employee {string} matches the the globally stored emp_firstname")
    public void the_partially_update_Employee_matches_the_the_globally_stored_emp_firstname(String value) {
        response.then().assertThat().body(value, equalTo(partiallyUpdated_first_name));
    }

    //-----------------Delete the Employee---------------------------------
    @Given("a request is prepared to delete the employee")
    public void a_request_is_prepared_to_delete_the_employee() {
        request = given().header(apiConstants.header_Content_type, apiConstants.content_type)
                .header(apiConstants.header_authorization, generateToken.token)
                .queryParam("employee_id", employeeID);
    }

    @When("a DELETE call is made to delete the employee")
    public void a_DELETE_call_is_made_to_delete_the_employee() {
        response = request.when().delete(apiConstants.DELETE_EMPLOYEE_URI);
    }
    @Then("the status code is {int}")
    public void the_status_code_is(int status_code) {
        //assert the status code
        response.then().assertThat().statusCode(status_code);
    }
    @Then("the employee is successfully deleted with {string} in response {string}")
    public void the_employee_is_successfully_deleted_with_in_response(String key, String value) {
        response.then().assertThat().body(key, equalTo(value));
    }
    @Then("the {string} is same as the one stored in global")
    public void the_is_same_as_the_one_stored_in_global(String employee_id) {
        response.then().assertThat().body(employee_id, equalTo(employeeID));
    }

    //-----------------------Retrieve all Employees-------------------------------
    @Given("a request is prepared to get all employees")
    public void a_request_is_prepared_to_get_all_employees() {
        request = given()
                .header(apiConstants.header_Content_type, apiConstants.content_type)
                .header(apiConstants.header_authorization, generateToken.token);
    }

    @When("GET call is made to retrieve all employees")
    public void get_call_is_made_to_retrieve_all_employees() {
        response = request.when().get(apiConstants.GET_ALL_EMPLOYEES_URI);
    }

    @Then("the status code of the request is {int}")
    public void the_status_code_of_the_request_is(int status_code) {
        response.then().assertThat().statusCode(status_code);
    }

    @Then("it contains key1 {string} and key2 {string}")
    public void it_contains_key1_and_key2(String key1, String key2) {
        //response.then().assertThat().body(containsString(key1)).body(containsString(key2));
        /*String payload = response.asString();
        JsonPath js = new JsonPath(payload);
        int count = js.getInt("Employees.size()");*/
        //print all Employee IDs
        /*for(int i = 0; i<count; i++){
            String allEmployeeIDs = js.getString("Employees["+i+"].employee_id");
            System.out.println(allEmployeeIDs);
        }*/

        //Get Employee first name(or employee_id for instance) of each employee in Syntax Hrms database
        String response_string = response.asString();
        JsonObject response_getAllEmployees = JsonParser.parseString(response_string).getAsJsonObject();
        JsonArray array_OfAllEmployees = response_getAllEmployees.get("Employees").getAsJsonArray();

        for (int i = 0; i < 100; i++) {
            JsonObject employee_0_info = array_OfAllEmployees.get(i).getAsJsonObject();
            String employee_id_x = employee_0_info.get("employee_id").getAsString();
            System.out.println(employee_id_x);
        }
        //another variant of loop
        /*for(JsonElement x: array_OfAllEmployees) {
            JsonObject employee_data = x.getAsJsonObject();
            String employee_firstName = employee_data.get("employee_id").getAsString();
            System.out.println(employee_firstName);
        }*/
    }
    //-----------------------Get all employees statuses-----------------------------
    @Given("a request is prepared to get all employees statuses")
    public void a_request_is_prepared_to_get_all_employees_statuses() {
        request = given()
                .header(apiConstants.header_Content_type, apiConstants.content_type)
                .header(apiConstants.header_authorization, generateToken.token);
    }

    @When("a GET call is made to retrieve the statuses of all employees")
    public void a_GET_call_is_made_to_retrieve_the_statuses_of_all_employees() {
        response = request.when().get(apiConstants.GET_EMPLOYEES_STATUS_URI);
    }
    @Then("it contains value1 {string} and value2 {string}")
    public void it_contains_value1_and_value2(String value1, String value2) {
        //response.then().assertThat().body(containsString(value1)).body(containsString(value2));
        String response_string = response.asString();
        JsonObject response_getAllEmployees = JsonParser.parseString(response_string).getAsJsonObject();
        JsonElement employee_status_list = response_getAllEmployees.get("Employee Status List");

        String status_list = employee_status_list.toString();
        //System.out.println(status_list);
        String status1 = status_list.replace("[", "");
        String status2 = status_list.replace("]", "");
        String[] statusList = status1.split(",");

        System.out.println(statusList[0]);
    }

}
