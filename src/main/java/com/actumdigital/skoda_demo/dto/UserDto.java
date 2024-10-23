package com.actumdigital.skoda_demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record UserDto(
        UUID id,
        String email,
        String firstname,
        String lastname,
        @JsonProperty(value = "addresses")
        AddressDto address,
        String phoneNumber) {
}
