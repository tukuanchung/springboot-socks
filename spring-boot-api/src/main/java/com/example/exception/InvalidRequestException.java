package com.example.exception;

import org.springframework.validation.Errors;

/**
 * Created by kuanchungtu on 2020/2/23
 */
public class InvalidRequestException extends RuntimeException {

    private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
