package com.actumdigital.skoda_demo.exception;

public class CartException extends RuntimeException {

    public static CartException NOT_FOUND = new CartException("Cart not found");

    public CartException(String message) {
        super(message);
    }
}
