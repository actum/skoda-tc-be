package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.CartDto;
import com.actumdigital.skoda_demo.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

@Component
public class CartMapper {

    private final UserMapper userMapper;
    private final CartItemMapper cartItemMapper;

    public CartMapper(UserMapper userMapper, CartItemMapper cartItemMapper) {
        this.userMapper = userMapper;
        this.cartItemMapper = cartItemMapper;
    }

    public CartDto toDto(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }

        return new CartDto(
                cart.getId(),
                cart.getItems().stream().map(cartItemMapper::toDto).collect(toCollection(ArrayList::new)),
                userMapper.toDto(cart.getUser()),
                cart.getTotalPrice()
        );
    }
}
