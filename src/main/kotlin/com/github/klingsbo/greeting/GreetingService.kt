package com.github.klingsbo.greeting

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingService {
    fun newHello() = GreetingDto("New Hello", "v1")
}
