package com.hrms.api;

import com.hrms.utils.apiConstants;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class generateToken {
    String BaseURI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    static String token;
    @Given("a JWT is generated")
    public void a_JWT_is_generated() {
        RequestSpecification generateTokenRequest = given().header("Content-type", "application/json")
                .body("{\n" +
                        "  \"email\": \"sofakosn123@gmail.com\",\n" +
                        "  \"password\": \"12345kjkkk\"\n" +
                        "}");
        Response generateTokenResponse = generateTokenRequest.when().post(apiConstants.GENERATE_TOKEN_URI);
        generateTokenResponse.prettyPrint();
        token = "Bearer " + generateTokenResponse.jsonPath().getString("token");

    }
}
