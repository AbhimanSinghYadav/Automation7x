package com.thetestingacademy;

import io.restassured.RestAssured;

public class Test002 {
    public static void main(String[] args) {
        System.out.println("rest assured test case");
        System.out.println("Get request demo");
        //gherkin syntax
        //given-url,body/payload,headers
        //when-http method-get,put,post,patch
        //verify the response
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1").log().all()
                .when()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
