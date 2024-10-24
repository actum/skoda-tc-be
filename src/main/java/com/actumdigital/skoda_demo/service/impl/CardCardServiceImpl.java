package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.CreditCardDto;
import com.actumdigital.skoda_demo.exception.AddressException;
import com.actumdigital.skoda_demo.exception.CreditCardException;
import com.actumdigital.skoda_demo.mapper.CreditCardMapper;
import com.actumdigital.skoda_demo.model.CreditCard;
import com.actumdigital.skoda_demo.repository.CreditCardRepository;
import com.actumdigital.skoda_demo.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CardCardServiceImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final CreditCardMapper creditCardMapper;

    public CardCardServiceImpl(CreditCardRepository creditCardRepository, CreditCardMapper creditCardMapper) {
        this.creditCardRepository = creditCardRepository;
        this.creditCardMapper = creditCardMapper;
    }

    @Override
    public CreditCardDto updateCreditCard(final UUID cardId, final CreditCardDto creditCardDto) {
        Optional<CreditCard> maybeAddress = creditCardRepository.findById(cardId);

        if (maybeAddress.isPresent()) {
            final CreditCard creditCard = maybeAddress.get();
            creditCard.setNumber(creditCardDto.number());
            creditCard.setExpiryMonth(creditCardDto.expiryMonth());
            creditCard.setExpiryYear(creditCardDto.expiryYear());
            creditCard.setCvv(creditCardDto.cvv());

            return creditCardMapper.toDto(creditCardRepository.save(creditCard));
        } else {
            throw CreditCardException.NOT_FOUND;
        }
    }
}
