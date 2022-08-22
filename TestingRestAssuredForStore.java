package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class TestingRestAssuredForStore {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void apostRequest() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": 10,\n" +
                        "    \"petId\": 100,\n" +
                        "    \"quantity\": 2,\n" +
                        "    \"shipDate\": \"2022-08-10T06:26:59.586Z\",\n" +
                        "    \"status\": \"placed\",\n" +
                        "    \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
        Assertions.assertEquals(200,response.statusCode());
    }

    @Test
    public void bgetRequest() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/store/order/10");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void hgetRequest() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void zdeleteRequest() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/10");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
