package com.thetestingacademy.ex_26102024.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    static RequestSpecification r= RestAssured.given();
    public void main(String[] args) {
       // r.relaxedHTTPSValidation("TLS");--HTTP Related issue
        r.baseUri("https://api.zippopotam.us/");
        //Rest assured provide us the lot of classes.
       // RequestSpecification r= RestAssured.given();
       // r.baseUri("https://api.zippopotam.us/");
       // r.basePath("/IN/224001");
       // r.when().get();
       // r.then().log().all().statusCode(200);
        testnonbdd_1();
        testnonbdd_2();


    }

    private void testnonbdd_2() {
        r.basePath("/IN/-1");
        r.when().get();
        r.then().log().all().statusCode(404);

    }

    private void testnonbdd_1() {
         r.basePath("/IN/224001");
         r.when().get();
        r.then().log().all().statusCode(200);

    }
}
