package com.thetestingacademy.testng;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test001 {

    @Test
    public void test_get(){
        RestAssured
                .given().relaxedHTTPSValidation()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/224001")
                .when().log().all().get().then().log().all().statusCode(200);

    }

}
