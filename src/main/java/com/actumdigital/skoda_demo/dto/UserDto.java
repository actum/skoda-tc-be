package com.actumdigital.skoda_demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record UserDto(
        UUID id,
        String email,
        String firstName,
        String lastName,
        @JsonProperty(value = "addresses")
        List<AddressDto> addressList) {
}
