package com.thetestingacademy.ex_30112024.pojos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class POJO002 {
    //Hashmap example
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingid;
    //{
    //     "bookingid": 490,
    //         "booking": {
    //     "firstname": "Abhi yadav",
    //              "lastname": "Brown",
    //              "totalprice": 111,
    //              "depositpaid": true,
    //              "bookingdates": {
    //          "checkin": "2018-01-01",
    //                  "checkout": "2019-01-01"
    //      },
    //      "additionalneeds": "Breakfast"
    //   }
    //   }
    //}
//Hashmap
//{} -map
    @Test
    public String test_with_hashma(){

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname", "abhi");
        jsonBodyUsingMap.put("lastname", "yadav");
        jsonBodyUsingMap.put("totalprice", 111); // Use Integer for numeric values
        jsonBodyUsingMap.put("depositpaid", true); // Use Boolean for boolean values

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2018-01-01");
        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");

        System.out.println(jsonBodyUsingMap);

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        // Sending the POST request
        Response response = requestSpecification.when().post();

        // Validating the response
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200); // Ensure status code is 200

        String bookingid = response.jsonPath().getString("bookingid");
        return bookingid;
    }
    }

