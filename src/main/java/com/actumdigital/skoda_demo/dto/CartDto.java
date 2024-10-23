package com.actumdigital.skoda_demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class CartDto {

    private final Long id;

    @JsonProperty("products")
    private final List<CartItemDto> cartItems;

    @JsonIgnore
    private final UserDto user;
    private final Double totalPrice;

    public CartDto(Long id, List<CartItemDto> cartItems, UserDto user, Double totalPrice) {
        this.id = id;
        this.cartItems = cartItems;
        this.user = user;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public UserDto getUser() {
        return user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
