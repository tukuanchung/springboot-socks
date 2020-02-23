package com.example.exception;

/**
 * Created by kuanchungtu on 2020/2/23
 */
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
