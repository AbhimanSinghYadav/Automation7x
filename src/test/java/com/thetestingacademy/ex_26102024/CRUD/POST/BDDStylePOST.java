package com.thetestingacademy.ex_26102024.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStylePOST {
     // Payload=String(1),Hashmap(4),Classes(97%)
    //POST REQUEST
    //URL--https://restful-booker.herokuapp.com/auth
    //BODY-PAYLOAD-JSON
    //{
     //    "username":"admin",
     //    "password" :"password123"
    //}
    //HEADER --Content  Type   -->application/json

    public static void main(String[] args) {
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

