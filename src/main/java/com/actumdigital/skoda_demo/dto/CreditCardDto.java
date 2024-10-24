package com.actumdigital.skoda_demo.dto;

import java.util.UUID;

public record CreditCardDto(UUID id,String number, String expiryMonth, String expiryYear, String cvv) {
}
