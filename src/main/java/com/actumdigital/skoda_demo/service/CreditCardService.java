package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.CreditCardDto;

import java.util.UUID;

public interface CreditCardService {

    CreditCardDto updateCreditCard(UUID cardId, CreditCardDto cardDto);

}
