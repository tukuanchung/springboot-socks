package com.example.handler;

import com.example.exception.InvalidRequestException;
import com.example.exception.NotFoundException;
import com.example.resource.ErrorResource;
import com.example.resource.FieldResource;
import com.example.resource.InvalidErrorResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuanchungtu on 2020/2/23
 */

@RestControllerAdvice
public class ApiExceptionHandler {
    /**
     * 處理資源找不到異常
     * @param e
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleNoFound(RuntimeException e){
        ErrorResource errorResource = new ErrorResource((e.getMessage()));
        return new ResponseEntity<Object>(errorResource, HttpStatus.NOT_FOUND);
    }

    /**
     * 處理參數驗證失敗
     * @param e
     * @return
     */
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    public ResponseEntity<?> handleInvalidRequest(InvalidRequestException e){
        Errors errors = e.getErrors();
        List<FieldResource> fieldResources = new ArrayList<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();

        for(FieldError fieldError :  fieldErrors){
            FieldResource fieldResource = new FieldResource(fieldError.getObjectName(),
                    fieldError.getField(),
                    fieldError.getCode(),
                    fieldError.getDefaultMessage());
            fieldResources.add(fieldResource);
        }
        InvalidErrorResource ier = new InvalidErrorResource(e.getMessage(), fieldResources);
        return new ResponseEntity<Object>(ier, HttpStatus.BAD_REQUEST);
    }

    /**
     * 處理全局異常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(Exception e){
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
