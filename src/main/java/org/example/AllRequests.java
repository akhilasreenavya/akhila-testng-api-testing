
package org.example;


import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class AllRequests{
    @Test(priority = 1)
    public void test1() {

            given().queryParam("CUSTOMER_ID","68195")
                    .queryParam("PASSWORD","1234!")
                    .queryParam("Account_No","1")
                    .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                    .body();
        }

    @BeforeTest

    public void test2() {

        given().get("https://reqres.in/api/users?page=2").then().
                statusCode(200).
                body("data.id[1]", equalTo(8)).
                body("data.first_name", hasItems("Michael","Lindsay")).
                log().all();

    }

    @AfterTest
    public void test3() {

        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "BA");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201 );

    }

    @Test(priority = 2)

    public void test4() {

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

    @Test(priority = 3)
    public void test5() {

        JSONObject request = new JSONObject();
        given().
                body(request.toJSONString()).
                when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204).
                log().all();

    }

}
