package com.actumdigital.skoda_demo.exception;

public class UserException extends RuntimeException {

    public static UserException NOT_FOUND = new UserException("User not found");

    public UserException(String message) {
        super(message);
    }
}
