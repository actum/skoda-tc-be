package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.OrderAddressDto;
import com.actumdigital.skoda_demo.model.OrderAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderAddressMapper {

    OrderAddressDto toDto(OrderAddress address);
}
