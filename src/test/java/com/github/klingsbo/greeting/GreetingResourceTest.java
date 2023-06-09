package com.github.klingsbo.greeting;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(GreetingResource.class)
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given().when().get().then().statusCode(200).body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    public void testPost() {
        given().when().post().then().statusCode(201);
    }

    @Test
    public void newTestHelloEndpoint() {
        given().when().put().then().statusCode(200).body("message", equalTo("New Hello"));
    }
}