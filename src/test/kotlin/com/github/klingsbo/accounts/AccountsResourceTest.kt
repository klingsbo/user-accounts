package com.github.klingsbo.accounts

import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@QuarkusTest
@TestHTTPEndpoint(AccountsResource::class)
class AccountsResourceTest {

    @Test
    fun `create new account successfully`() {

    }
}