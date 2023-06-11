package com.jbb.userservice.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class UserServiceException extends RuntimeException {

    private final Map<String, String> validation = new HashMap<>();

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fieldName, String message) {
        this.validation.put(fieldName, message);
    }

}
