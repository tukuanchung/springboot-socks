package com.example.exception;

import org.springframework.validation.Errors;

/**
 * Created by kuanchungtu on 2020/2/23
 */
public class InvalidRequestException extends RuntimeException {

    private Errors error;

    public InvalidRequestException(String message, Errors error) {
        super(message);
        this.error = error;
    }
}
