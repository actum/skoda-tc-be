package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.AddressDto;

import java.util.UUID;

public interface AddressService {

    AddressDto updateAddress(UUID addressId, AddressDto addressDto);

}
