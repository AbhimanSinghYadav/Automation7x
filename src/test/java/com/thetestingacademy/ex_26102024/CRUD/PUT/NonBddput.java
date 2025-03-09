package com.thetestingacademy.ex_26102024.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
@Test
public class NonBddput {
    //4081
    //Token
    //Payload
   // {
   //     "firstname" : "Abhi yadav",
  //    "lastname" : "Brown",
  //          "totalprice" : 111,
  //          "depositpaid" : true,
 //           "bookingdates" : {
 //       "checkin" : "2018-01-01",
 //               "checkout" : "2019-01-01"
//    },
    //"additionalneeds" : "Breakfast"
   // }
    //POST-Auth-token
    //POST-BOOKING ID
    //PUT-Token and booking ID
    public void test_put_positive_tc(){
        //post-auth-token
        String token="eb85369e71a1ebe";
        String bookingid="897";
        String payloadPatch = "{\n" +
                "    \"firstname\": \"Vinod \",\n" +
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
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payloadPatch).log().all();
        // Sending the PUT request
        Response response = requestSpecification.when().put();
        // Validating the response
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200); // Ensure status code is 200
    }
}
