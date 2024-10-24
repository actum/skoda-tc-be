package com.actumdigital.skoda_demo.facade;

import com.actumdigital.skoda_demo.dto.AddressDto;
import com.actumdigital.skoda_demo.dto.CreditCardDto;
import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.service.AddressService;
import com.actumdigital.skoda_demo.service.CreditCardService;
import com.actumdigital.skoda_demo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserFacade {

    private final UserService userService;
    private final AddressService addressService;
    private final CreditCardService cardService;

    public UserFacade(UserService userService, AddressService addressService, CreditCardService cardService) {
        this.userService = userService;
        this.addressService = addressService;
        this.cardService = cardService;
    }

    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    public UserDto updateUserAddress(final UUID addressId, final AddressDto addressDto) {
        addressService.updateAddress(addressId, addressDto);
        return userService.getCurrentUser();
    }

    public UserDto updateCreditCard(final UUID cardId, final CreditCardDto creditCardDto) {
        cardService.updateCreditCard(cardId, creditCardDto);
        return userService.getCurrentUser();
    }
}
