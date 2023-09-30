package com.commerce.bikes.exceptions;

public class ObjectNotFoundException extends Exception {

    private String code;

    private String message;

    public ObjectNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() { return code;}
}
