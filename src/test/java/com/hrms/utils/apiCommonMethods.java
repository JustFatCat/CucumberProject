package com.hrms.utils;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class apiCommonMethods {
    /**
     * create employee request
     * @param token
     * @param employeeBody
     * @return
     */
    public static RequestSpecification createEmployeeRequest(String token, String employeeBody){
        return given().header(apiConstants.header_Content_type, "application.json").header(apiConstants.header_authorization, token)
                .body(employeeBody);
    }

    /**
     * get one employee request
     * @param token
     * @param employeeID
     * @return
     */
    public static RequestSpecification getOneEmployeeRequest(String token, String employeeID){
        return given().header(apiConstants.header_Content_type, "application.json")
                .header(apiConstants.header_authorization, token)
                .queryParam("employee_id", employeeID).log().all();
    }



}
