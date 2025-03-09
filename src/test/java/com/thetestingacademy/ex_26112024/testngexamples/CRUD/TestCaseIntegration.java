package com.thetestingacademy.ex_26112024.testngexamples.CRUD;

import groovyjarjarantlr4.v4.runtime.Dependents;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseIntegration {
    //Create a Token
    //Create a Booking
    //Perform a put request
    //Verify that put is success by get request
    //Delete the ID
    //Verify it does not exist get request
     RequestSpecification requestSpecification;
     ValidatableResponse validatableResponse;
     Response response;
    String token;
    String bookingid;

    @BeforeTest
    public String getToken(){
        String payload= "{"
                        + "\"username\":\"admin\","
                        + "\"password\":\"password123\""
                        + "}";
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).log().all().body(payload).when()

                .post().then().log().all().statusCode(200);
  //Extract the token
    token = response.jsonPath().getString("token");
    return token;
    }
    @BeforeTest
    public String getBookingID(){
        String payload_POST = "{\n" +
                "    \"firstname\": \"QA \",\n" +
                "    \"lastname\": \"Singh\",\n" +
                "    \"totalprice\": 333,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2023-01-01\",\n" +
                "        \"checkout\": \"2023-01-02\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast in evening\"\n" +
                "}";
        // Setting up the request
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking" );
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();
        // Sending the PUT request
        Response response = requestSpecification.when().post();
        // Validating the response
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200); // Ensure status code is 200
    bookingid=response.jsonPath().getString("bookingid");
     return bookingid;
    }
    @Test(priority = 1)
    public String test_update_request_put(){
        token=getToken();
        bookingid=getBookingID();
        String payload = "{\n" +
                "    \"firstname\": \"Raj \",\n" +
                "    \"lastname\": \"Kumar\",\n" +
                "    \"totalprice\": 333,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2023-01-01\",\n" +
                "        \"checkout\": \"2023-01-02\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast in evening\"\n" +
                "}";
        // Setting up the request
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/id" );
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();
        // Sending the PUT request
        Response response = requestSpecification.when().post();
        // Validating the response
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200); // Ensure status code is 200
        bookingid=response.jsonPath().getString("/booking/id");
        return bookingid;
    }
    @Test(priority =2)
    public void  test_update_request_get(){
        System.out.println(bookingid);
    }
   @Test(dependsOnMethods ="test_update_request_get")
    public void  test_delete_booking(){
        System.out.println(bookingid);
        System.out.println(token);
    }
    @Test(dependsOnMethods ="test_delete_booking" )
    public void  test_after_delete_request_get(){
        System.out.println(bookingid);
    }
}
