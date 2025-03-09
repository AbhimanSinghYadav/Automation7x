package com.thetestingacademy.ex_30112024;

import io.restassured.path.json.JsonPath;

public class Jsonpath02 {
    public static void main(String[] args) {
        String response = "{"
                + "\"firstname\":\"john\","
                + "\"lastname\":\"ramesh\","
                + "\"age\":26,"
                + "\"address\":{"
                + "\"streetAddress\":\"naiststreet\","
                + "\"city\":\"nara\","
                + "\"postalcode\":\"224001\""
                + "},"
                + "\"phoneNumbers\":["
                + "{"
                + "\"type\":\"iphone\","
                + "\"number\":\"7895784158\""
                + "},"
                + "{"
                + "\"type\":\"Home\","
                + "\"number\":\"7895784158\""
                + "}"
                + "]"
                + "}";
        JsonPath jsonPath=JsonPath.from(response);
        System.out.println(jsonPath.getString("firstName"));
        System.out.println(jsonPath.getString("phoneNumbers[1].type"));
    }
}
