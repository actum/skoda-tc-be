package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.CartItemDto;
import com.actumdigital.skoda_demo.model.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {

    public CartItemDto toDto(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("CartItem cannot be null");
        }

        return new CartItemDto(
                item.getProduct().getCode(),
                item.getProduct().getPrice());
    }
}
