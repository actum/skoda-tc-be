package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.dto.CreditCardDto;
import com.actumdigital.skoda_demo.dto.UserAddressDto;
import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.facade.UserFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(UsersController.BASE_URL)
public class UsersController {

    public static final String BASE_URL = "/users/current";

    UserFacade userFacade;

    public UsersController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping()
    public UserDto getCurrentUser() {
        return userFacade.getCurrentUser();
    }

    @PutMapping("/addresses/{addressId}")
    public UserDto updateAddress(@PathVariable("addressId") UUID addressId, @RequestBody UserAddressDto userAddressDto) {
        return userFacade.updateUserAddress(addressId, userAddressDto);
    }

    @PutMapping("/creditcards/{cardId}")
    public UserDto updateCreditCard(@PathVariable("cardId") UUID cardId, @RequestBody CreditCardDto cardDto) {
        return userFacade.updateCreditCard(cardId, cardDto);
    }
}
