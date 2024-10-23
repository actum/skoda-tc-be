package com.actumdigital.skoda_demo.exception;

public class AddressException extends RuntimeException {

    public static AddressException NOT_FOUND = new AddressException("Address not found");

    public AddressException(String message) {
        super(message);
    }
}
