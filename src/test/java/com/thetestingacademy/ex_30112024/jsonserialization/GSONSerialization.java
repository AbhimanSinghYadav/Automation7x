package com.thetestingacademy.ex_30112024.jsonserialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;


@Test
public class GSONSerialization {
     //Class-pojo
    //Create class for the payload-pojo
    //Putrequest
    //token,booking id
    public void testnonbdd(){
        RequestSpecification requestSpecification = RestAssured.given();
        Booking booking=new Booking();
        booking.setFirstname("abhiman kumar");
        booking.setLastname("singh");
        booking.setTotalprice(666);
        booking.setDepositpaid(true);
        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates); // Fixed method name

        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking);
        Gson gson=new Gson();
        String jsonStrinpayload=gson.toJson(booking);

        String BASE_URL="https://restful-booker.herokuapp.com";
        String BASE_PATH="/booking";

        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(BASE_PATH);
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(jsonStrinpayload);

        // Send POST request
        Response response = requestSpecification.body(booking).post();

        // Validate the response
        ValidatableResponse validatableResponse = response.then();

       // Ensure response status code is 200

        // Print the response as a string
        String responseString = response.asString(); // Fixed case sensitivity
        System.out.println(responseString);
        validatableResponse.statusCode(200);

    }

}
