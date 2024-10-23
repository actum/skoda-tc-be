package com.actumdigital.skoda_demo.dto;

import com.actumdigital.skoda_demo.enums.AddressType;

public record AddressDto(
        String street,
        String city,
        String postalCode,
        AddressType addressType) {
}
