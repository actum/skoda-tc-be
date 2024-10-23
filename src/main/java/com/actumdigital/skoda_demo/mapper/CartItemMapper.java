package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.CartItemDto;
import com.actumdigital.skoda_demo.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "code", source = "product.code")
    CartItemDto toDto(CartItem cartItem);

}
