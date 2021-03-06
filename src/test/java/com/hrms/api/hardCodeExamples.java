package com.hrms.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

//given()
//when()
//then()

public class hardCodeExamples {
    String baseURI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQzNjcxMTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDQxMDMxMCwidXNlcklkIjoiMjQzMiJ9.ROw0JwdUHhjfCosRujcMcULoDeNroXpeFqfQOWv374U";
    @Test
    public void sampleTest(){
        //preparing request to get one employee
        RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token).header("Content-Type", "Application/json")
                .queryParam("employee_id", "15731A");
        //sending the request to the end point
        Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");
        //print the response
        System.out.println(getOneEmployeeResponse.asString());
        //getOneEmployeeResponse.prettyPrint();

        //Assert that status code is 200
        getOneEmployeeResponse.then().assertThat().statusCode(200);
    }

    @Test
    public void aPostCreateEmployee(){
        //Preparing Create an Employee Request
        RequestSpecification createEmployeeRequest = given().header("Authorization", token).header("Content-Type", "Application/json").body("{\n" +
                "  \"emp_firstname\": \"Mariii\",\n" +
                "  \"emp_lastname\": \"Romaniuk\",\n" +
                "  \"emp_middle_name\": null,\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2021-02-11\",\n" +
                "  \"emp_status\": \"employee\",\n" +
                "  \"emp_job_title\": \"IT Analyst\"\n" +
                "}");
        //Making a Post Call to Create Employee
        Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
        createEmployeeResponse.prettyPrint();
        //Assert that status code is 201
        createEmployeeResponse.then().assertThat().statusCode(201);

        //Get Employee_id
        String employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        //Printing the Employee ID
        System.out.println(employeeID);
        //JsonPath js = createEmployeeResponse.jsonPath();
        //String employeeID = js.getString("Employee[0].employee_id");

        //Assert that message contains Entry Created
        createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
        //Assert that Employee ID is 16153A
        createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Mariii"));
    }

    @Test
    public void bGetCreatedEmployee(){
        RequestSpecification getCreatedEmployee = given().header("Authorization", token).header("Content-Type", "Application/json").queryParam("employee_id","16153A");
        Response getEmployeeResponse = getCreatedEmployee.when().get("/getOneEmployee.php");
        getEmployeeResponse.prettyPrint();
        String empID = getEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

        //we are checking if the empId is equal to the one mentioned in String
        boolean verifyEmployeeID = empID.equalsIgnoreCase("16153A");
        System.out.println(verifyEmployeeID);
        //Assert.assertTrue(verifyEmployeeID);
        getEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo("16153A"));
    }

    @Test
    public void cUpdateEmployee(){
        RequestSpecification updateEmployeeRequest = given().header("Content-type", "application/json").header("Authorization", token).body("{\n" +
                "  \"employee_id\": \"16153A\",\n" +
                "  \"emp_firstname\": \"ABCD\",\n" +
                "  \"emp_lastname\": \"Romaniuk\",\n" +
                "  \"emp_middle_name\": null,\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2021-02-11\",\n" +
                "  \"emp_status\": \"employee\",\n" +
                "  \"emp_job_title\": \"IT Analyst\"\n" +
                "}");
        Response updateEmployeeResponse = updateEmployeeRequest.when().put("/updateEmployee.php");
        updateEmployeeResponse.prettyPrint();

        //assert that updated information is correct
        //String firstName = updateEmployeeResponse.jsonPath().getString("employee[0].emp_firstname");
        JsonPath js = updateEmployeeResponse.jsonPath();
        String employee_firstname = js.getString("employee[0].emp_firstname");
        System.out.println(employee_firstname);

        //assertThat(employee_firstname, equalTo("ABCD"));

        //another way
        updateEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("ABCD"));

        //the other way: create boolean and use assert from jUnit
    }

    @Test
    public void dPartiallyUpdateEmployee(){
        RequestSpecification partiallyUpdateRequest = given().header("Content-type", "application/json").header("Authorization", token).body("" +
                "{\n" +
                "            \"employee_id\": \"16153A\",\n" +
                "            \"emp_firstname\": \"updated name\"\n" +
                "        }");

        Response partiallyUpdateEmployeeResponse = partiallyUpdateRequest.when().patch("/updatePartialEmplyeesDetails.php");
        partiallyUpdateEmployeeResponse.prettyPrint();

        //assert that body contains message "Entry updated"
        JsonPath js = partiallyUpdateEmployeeResponse.jsonPath();
        Object message = js.get("Message");
        //System.out.println(message);
        assertThat(message, equalTo("Entry updated"));

        //the other method
        partiallyUpdateEmployeeResponse.then().assertThat().body("Message", containsString("Entry updated"));
    }
    @Test
    public void dDeleteEmployeeRequest(){
        RequestSpecification deleteEmployeeRequest = given().header("Content-type", "application/json").header("Authorization", token).queryParam("employee_id", "16479A");
        Response deleteEmployeeResponse = deleteEmployeeRequest.when().delete("/deleteEmployee.php");
        deleteEmployeeResponse.prettyPrint();

        //assert that message contains "Entry deleted"
        deleteEmployeeResponse.then().assertThat().body("message", containsString("Entry deleted"));


    }

}
