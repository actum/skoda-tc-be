package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.CreditCardDto;
import com.actumdigital.skoda_demo.model.CreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditCardMapper {

    CreditCardDto toDto(CreditCard creditCard);
}
