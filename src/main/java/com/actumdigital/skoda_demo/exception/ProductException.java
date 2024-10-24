package com.actumdigital.skoda_demo.exception;

public class ProductException extends RuntimeException {

    public static ProductException NOT_FOUND = new ProductException("Product not found");

    public ProductException(String message) {
        super(message);
    }
}
