package com.thetestingacademy.ex_30112024;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Jsonpath01 {
    @Test
    public void test_post() {
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
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();
        // Sending the PUT request
        Response response = requestSpecification.when().post();
        System.out.println(response.asString());
       JsonPath jsonpath=new JsonPath(response.asString());
       String bookingid=jsonpath.getString("bookingid");;
       String firstname=jsonpath.getString("booking.first name");
       String checkout=jsonpath.getString("booking.bookingdates.checkout");
        System.out.println(bookingid);
        System.out.println(firstname);
        System.out.println(checkout);
       assertThat(bookingid).isNotNull().isNotBlank();
       assertThat(firstname).isNotNull().isNotBlank().isEqualTo("Pramod");
       assertThat(checkout).isNotNull().isNotBlank();
    }
}