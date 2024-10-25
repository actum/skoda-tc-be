package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.AddressDto;
import com.actumdigital.skoda_demo.exception.AddressException;
import com.actumdigital.skoda_demo.mapper.AddressMapper;
import com.actumdigital.skoda_demo.model.Address;
import com.actumdigital.skoda_demo.repository.AddressRepository;
import com.actumdigital.skoda_demo.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDto updateAddress(final UUID addressId, final AddressDto addressDto) {
        Optional<Address> maybeAddress = addressRepository.findById(addressId);

        if(maybeAddress.isPresent()) {
            final Address address = maybeAddress.get();
            address.setStreet(addressDto.street());
            address.setHouseNumber(addressDto.houseNumber());
            address.setCity(addressDto.city());
            address.setPostalCode(addressDto.postalCode());
            address.setAddressType(addressDto.addressType());
            address.setCompanyName(addressDto.companyName());
            address.setVAT(addressDto.VAT());

            return addressMapper.toDto(addressRepository.save(address));
        } else {
            throw AddressException.NOT_FOUND;
        }
    }
}
