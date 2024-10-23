package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.CartDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    CartDto getActiveCart(User user);

    CartDto addProductToCart(ProductDto productDto, User user);

    CartDto removeProductFromCart(ProductDto productDto, User user);

    void deleteCart(Long cartId);
}
