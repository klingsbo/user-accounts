package com.github.klingsbo.accounts

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class AccountsResource(val accountsService: AccountsService) {

    @POST
    fun create(dto: CreateAccountDto): Response =
        Response.status(Response.Status.CREATED).entity(accountsService.createAccount(dto.email)).build()
}
