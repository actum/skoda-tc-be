package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.CartDto;
import com.actumdigital.skoda_demo.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CartItemMapper.class})
public interface CartMapper {

    @Mapping(target = "user", source = "user")
    CartDto toDto(Cart cart);

    List<CartDto> toDtoList(List<Cart> carts);
}
