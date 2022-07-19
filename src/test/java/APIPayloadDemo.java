import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIPayloadDemo {

    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";
//    1- format issue
//    2- hard coded
//    3- escape charaters
//    4- maintenance
//    5- scalability

    @Test
    public void postRequest1() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .header("Content-type", "application/json")
                .and().body(requestBody)
                .when().post("/posts")
                .then().extract().response();
        response.prettyPrint();
    }
    @Test
    public void postRequest2() {
        //1- create object
        PojoRequestBody pojoRequestBody= new PojoRequestBody();
        //2- assign
        pojoRequestBody.title="foo";
        pojoRequestBody.body="bar";
        pojoRequestBody.userId="1";
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .header("Content-type", "application/json")
                .and().body(pojoRequestBody)
                .when().post("/posts")
                .then().extract().response();
        Assert.assertEquals(201, response.statusCode());
      }
}
