package com.actumdigital.skoda_demo.dto;

import java.util.UUID;

public record CreditCardDto(UUID id,String number, Integer expiryMonth, Integer expiryYear, Integer cvv) {
}
