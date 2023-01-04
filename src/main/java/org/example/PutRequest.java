package org.example;

import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutRequest {
    @Test
    public void put() {

        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "BAA");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().statusCode(200);

    }
}
