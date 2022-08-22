package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class TestingRestAssuredForUser {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void acreateUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"Swapnil\",\n" +
                        "  \"firstName\": \"swapnil\",\n" +
                        "  \"lastName\": \"Pawar\",\n" +
                        "  \"email\": \"sopiswarrinku77@gmail.com\",\n" +
                        "  \"password\": \"sopi@1234\",\n" +
                        "  \"phone\": \"8600127352\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        Assertions.assertEquals(200,response.statusCode());
    }

    @Test
    public void bgetUserByUserName() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/Swapnil");
                response.prettyPrint();
                response.then().assertThat().statusCode(200);

    }

    @Test
    public void cupdatedUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"Akshay\",\n" +
                        "  \"firstName\": \"akshay\",\n" +
                        "  \"lastName\": \"Pawar\",\n" +
                        "  \"email\": \"akshu23@gmail.com\",\n" +
                        "  \"password\": \"akshu@1234\",\n" +
                        "  \"phone\": \"8600127352\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/Swapnil");
        response.prettyPrint();
        Assertions.assertEquals(200,response.statusCode());
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("https://petstore.swagger.io/v2/user/Swapnil");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void ecreateWithList() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 20,\n" +
                        "    \"username\": \"Rahul\",\n" +
                        "    \"firstName\": \"Rahul\",\n" +
                        "    \"lastName\": \"Patil\",\n" +
                        "    \"email\": \"RahulPatil@gmail.com\",\n" +
                        "    \"password\": \"Rahul@1234\",\n" +
                        "    \"phone\": \"8675645342\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
        Assertions.assertEquals(200,response.statusCode());
    }
}
