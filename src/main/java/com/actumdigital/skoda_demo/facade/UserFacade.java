package com.actumdigital.skoda_demo.facade;

import com.actumdigital.skoda_demo.dto.AddressDto;
import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.service.AddressService;
import com.actumdigital.skoda_demo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserFacade {

    private final UserService userService;
    private final AddressService addressService;

    public UserFacade(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    public UserDto updateUserAddress(final UUID addressId, final AddressDto addressDto) {
        addressService.updateAddress(addressId,addressDto);
        return userService.getCurrentUser();
    }
}
