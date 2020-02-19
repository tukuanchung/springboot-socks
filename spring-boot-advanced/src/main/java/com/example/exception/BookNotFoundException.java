package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kuanchungtu on 2020/2/19
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(){

    }

    public BookNotFoundException(String message){
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
