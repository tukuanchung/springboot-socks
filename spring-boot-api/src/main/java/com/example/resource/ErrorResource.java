package com.example.resource;

/**
 * Created by kuanchungtu on 2020/2/23
 */
public class ErrorResource {
    private String message;

    public ErrorResource(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
