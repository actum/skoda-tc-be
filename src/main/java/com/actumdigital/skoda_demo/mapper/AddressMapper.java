package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.AddressDto;
import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.model.Address;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto toDto(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        return new AddressDto(
                address.getStreet(),
                address.getCity(),
                address.getPostalCode(),
                address.getAddressType()
        );
    }
}
