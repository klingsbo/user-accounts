package com.github.klingsbo.accounts

import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response

@Path("/accounts")
class AccountsResource(val accountsService: AccountsService) {

    @POST
    fun create(createAccountDto: CreateAccountDto) =
        Response.status(Response.Status.CREATED).entity(accountsService.createAccount(createAccountDto)).build()
}
