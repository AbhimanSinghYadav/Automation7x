package com.thetestingacademy.ex_26102024.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDstyle {
    public static void main(String[] args) {
        //Given--Request spec
        RequestSpecification r= RestAssured.given();
        String payload=
                "{"
                        + "\"username\":\"admin\","
                        + "\"password\":\"password123\""
                        + "}";
        r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");
                r.contentType(ContentType.JSON).log().all();
                        r.body(payload).when()
                .post().then().log().all().statusCode(200);
         //When -Response
        Response response=r.when().post();
         //Then -Validatable response
        //Validation
        ValidatableResponse validatablevResponse=response.then();
       validatablevResponse.statusCode(200);
    }
}

