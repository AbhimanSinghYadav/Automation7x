package com.thetestingacademy.ex_30112024.jsonserialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Test
public class GSONDeserialization {
    //Class-pojo
    //Create class for the payload-pojo
    //Putrequest
    //token,booking id
    public void testnonbdd(){
        RequestSpecification requestSpecification = RestAssured.given();
        Booking booking=new Booking();
        booking.setFirstname("abhiman");
        booking.setLastname("yadav");
        booking.setTotalprice(555);
        booking.setDepositpaid(true);
        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates); // Fixed method name

        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking);
        Gson gson=new Gson();
        String jsonStrinpayload=gson.toJson(booking);
        System.out.println(jsonStrinpayload);
        String BASE_URL="https://restful-booker.herokuapp.com";
        String BASE_PATH="/booking";

        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(BASE_PATH);
        requestSpecification.contentType(ContentType.JSON);

        // Send POST request
        Response response = requestSpecification.body(booking).post();

        // Validate the response
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200); // Ensure response status code is 200

        // Print the response as a string
        String responseString = response.asString(); // Fixed case sensitivity
        System.out.println(responseString);
        //ParseDeserialization
       BookingResponse bookingResponse=gson.fromJson(responseString, BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());

    }
}
