package com.nishasoni.Rest_Demo.exception;

public class VenderNotFoundException extends RuntimeException{

    public VenderNotFoundException(String message) {
        super(message);
    }

    public VenderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
