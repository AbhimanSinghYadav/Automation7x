package com.thetestingacademy.ex_30112024.pojos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POJO001 {
    public static void main(String[] args) {
        //String payload
        String payload=
                "{"
                        + "\"username\":\"admin\","
                        + "\"password\":\"password123\""
                        + "}";
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).log().all().body(payload).when()

                .post().then().log().all().statusCode(200);
    }
}
