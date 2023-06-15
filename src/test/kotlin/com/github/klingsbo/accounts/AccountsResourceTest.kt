package com.github.klingsbo.accounts

import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.Header
import jakarta.transaction.Transactional
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

@QuarkusTest
@TestHTTPEndpoint(AccountsResource::class)
class AccountsResourceTest {

    @Test
    fun `create new account successfully`() {
        val testEmail = "${UUID.randomUUID()}@mail.com"
        given()
            .header(Header("Content-Type", "application/json"))
            .header(Header("Accept", "application/json"))
            .body("{\"email\": \"$testEmail\"}")
            .`when`().post()
            .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("createdAt", notNullValue())
            .body("email", equalTo(testEmail))

        Account.findByEmail(testEmail)!!
    }

    @Test
    @Transactional
    fun `create new account return conflicts`() {
        val testEmail = "${UUID.randomUUID()}@mail.com"

        given()
            .header(Header("Content-Type", "application/json"))
            .header(Header("Accept", "application/json"))
            .body("{\"email\": \"$testEmail\"}")
            .`when`().post()
            .then()
            .statusCode(201)

        given()
            .header(Header("Content-Type", "application/json"))
            .header(Header("Accept", "application/json"))
            .body("{\"email\": \"$testEmail\"}")
            .`when`().post()
            .then()
            .statusCode(409)
    }
}