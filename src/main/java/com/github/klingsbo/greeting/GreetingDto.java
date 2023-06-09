package com.github.klingsbo.greeting;

public class GreetingDto {
    public String message;
    public String version;

    public GreetingDto(final String message, final String version) {
        this.message = message;
        this.version = version;
    }
}
