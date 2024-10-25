package com.actumdigital.skoda_demo.dto;

import com.actumdigital.skoda_demo.enums.AddressType;
import com.actumdigital.skoda_demo.enums.Country;

import java.util.UUID;

public record UserAddressDto(UUID id,
                             String street,
                             Integer houseNumber,
                             String city,
                             String postalCode,
                             String companyName,
                             String VAT,
                             AddressType addressType,
                             Country country,
                             String phoneNumber,
                             String firstname,
                             String lastname) {
}
