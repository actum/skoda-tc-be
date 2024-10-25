package com.actumdigital.skoda_demo.dto;

import java.util.UUID;


public record UserDto(
        UUID id,
        String email,
        String firstname,
        String lastname,
        String phoneNumber,
        AddressDto address,
        CreditCardDto creditCard) {
}
