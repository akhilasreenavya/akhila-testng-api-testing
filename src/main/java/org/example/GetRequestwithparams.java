package org.example;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequestwithparams {
    @Test

    public void getparam() {

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
    }
}
