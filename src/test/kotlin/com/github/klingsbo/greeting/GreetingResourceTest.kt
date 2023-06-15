package com.github.klingsbo.greeting

import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test

@QuarkusTest
@TestHTTPEndpoint(GreetingResource::class)
class GreetingResourceTest {
    @Test
    fun testHelloEndpoint() {
        RestAssured.given().`when`().get().then().statusCode(200).body(CoreMatchers.`is`("Hello from RESTEasy Reactive"))
    }

    @Test
    fun testPost() {
        RestAssured.given().`when`().post().then().statusCode(201)
    }

    @Test
    fun newTestHelloEndpoint() {
        RestAssured.given().`when`().put().then().statusCode(200).body("message", CoreMatchers.equalTo("New Hello"))
    }
}