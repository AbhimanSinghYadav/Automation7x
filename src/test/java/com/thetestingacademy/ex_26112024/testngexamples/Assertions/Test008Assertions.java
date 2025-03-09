package com.thetestingacademy.ex_26112024.testngexamples.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test008Assertions {
    //Post -Create- >Verify the response
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingid;
    @Test(description = "This is test")
    public void test_post(){
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
        //Rest Assured Default-Hamcrest
       //validatableResponse.body(Matchers.contains("booking.firstname",Matchers.equalTo("Abhiman")));
       // validatableResponse.body(Matchers.contains("bookingid",Matchers.notNullValue()));
        //TestNG Assertion
        //SoftAssert vs
        //HardAssert-This means that if any assertions fails,the remaining test method will not be executed.
       bookingid = Integer.valueOf(response.jsonPath().getString("bookingid"));
      String firstname=response.then().extract().path("booking.firstname");
      //  Assert.assertNotNull(bookingid);
      //  Assert.assertEquals(firstname,"Pramod");
        //AssertJ Assertion
        assertThat(bookingid).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("QA").isNotEmpty().isNotBlank();
       // String s="";//Empty
       // String s2=" "; //Blank

        //bookingid = response.jsonPath().getString("bookingid");
        //return bookingid;
    }

    }
