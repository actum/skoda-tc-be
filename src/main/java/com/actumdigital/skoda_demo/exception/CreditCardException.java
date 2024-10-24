package com.actumdigital.skoda_demo.exception;

public class CreditCardException extends RuntimeException {

    public static CreditCardException NOT_FOUND = new CreditCardException("Credit card not found");

    public CreditCardException(String message) {
        super(message);
    }
}
