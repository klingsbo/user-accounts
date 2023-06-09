package com.github.klingsbo.greeting;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public GreetingDto newHello() {
        return new GreetingDto("New Hello", "v1");
    }
}
