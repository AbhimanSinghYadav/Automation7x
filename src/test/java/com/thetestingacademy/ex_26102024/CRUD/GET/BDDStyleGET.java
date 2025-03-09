package com.thetestingacademy.ex_26102024.CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {
        //Then
        //Response validation
        //Status code
        //Response body
        //Time,headers,Cookies
        test1 ();
        test2 ();

    }
    public static void test1() {
        RestAssured
                .given().relaxedHTTPSValidation()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/224001")
                .when().log().all().get().then().log().all().statusCode(200);


    }

    public static void test2() {
        RestAssured
                .given().relaxedHTTPSValidation()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/-1")
                .when().log().all().get().then().log().all().statusCode(200);
    }
}

       // RestAssured
      //          .given()
        //           .baseUri("https://api.zippopotam.us/")
        //           .basePath("/IN/224001")
        //         .when().log().all().get().then().log().all().statusCode(200);


        //   RestAssured
        //          .given()
        //         .baseUri("https://api.zippopotam.us/")
        //         .basePath("/IN/-1")
        //          .when().log().all().get().then().log().all().statusCode(200);

