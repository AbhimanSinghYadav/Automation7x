package com.thetestingacademy.ex_30112024.jsonserialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;
@Test
public class Withoutserialization {
    public void testnonbddstyle() {
        RequestSpecification requestSpecification = RestAssured.given();
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

// Set up the request specification
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(BASE_PATH);
        requestSpecification.contentType(ContentType.JSON);

// Send the POST request and validate the response
        ValidatableResponse response = requestSpecification.when().post().then();

// Extract the response as a string
        String responseString = response.extract().body().asString();
        System.out.println(responseString);

// Validate the status code
        response.statusCode(200);
    }

}
