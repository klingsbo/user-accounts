package com.github.klingsbo.greeting

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/hello")
class GreetingResource @Inject constructor(private val greetingService: GreetingService) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from RESTEasy Reactive"

    @POST
    fun create() = Response.status(Response.Status.CREATED).build()

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun newHello() = greetingService.newHello()
}
