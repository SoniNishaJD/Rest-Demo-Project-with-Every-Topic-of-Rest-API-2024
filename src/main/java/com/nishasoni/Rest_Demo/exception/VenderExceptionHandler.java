package com.nishasoni.Rest_Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VenderExceptionHandler {

    @ExceptionHandler(value = {VenderNotFoundException.class})
    public ResponseEntity<Object> handleVenderNotFoundException
            (VenderNotFoundException venderNotFoundException){
        VenderException venderException = new VenderException(
                venderNotFoundException.getMessage(),
                venderNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(venderException,HttpStatus.NOT_FOUND);

    }
}
