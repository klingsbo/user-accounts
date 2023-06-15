package com.github.klingsbo.accounts.exceptions

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class AccountAlreadyExistsExceptionMapper : ExceptionMapper<AccountAlreadyExistsException> {

    override fun toResponse(exception: AccountAlreadyExistsException): Response =
        Response.status(Response.Status.CONFLICT).entity(exception.message).build()

}