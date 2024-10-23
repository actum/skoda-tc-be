package com.actumdigital.skoda_demo.facade;

import com.actumdigital.skoda_demo.dto.CartDto;
import com.actumdigital.skoda_demo.dto.CartEntryDto;
import com.actumdigital.skoda_demo.dto.CartItemDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.service.CartService;
import com.actumdigital.skoda_demo.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class CartFacade {

    private final CartService cartService;
    private final ProductService productService;

    public CartFacade(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    public CartDto getActiveCart(User user) {
        return cartService.getActiveCart(user);
    }

    public CartDto addProductToCart(CartEntryDto cartEntryDto, User user) {
        return cartService.addProductToCart(getProductFromCartEntry(cartEntryDto), user);
    }

    public CartDto removeProductFromCart(CartEntryDto cartEntryDto, User user) {
        return cartService.removeProductFromCart(getProductFromCartEntry(cartEntryDto), user);
    }

    private ProductDto getProductFromCartEntry(CartEntryDto cartEntryDto) {
        return productService.getProduct(cartEntryDto.code());
    }
}
