package com.actumdigital.skoda_demo.dto;

import com.actumdigital.skoda_demo.enums.AddressType;
import com.actumdigital.skoda_demo.enums.Country;

import java.util.UUID;

public record OrderAddressDto(
        String street,
        Integer houseNumber,
        String city,
        String postalCode,
        AddressType addressType,
        Country country) {
}
