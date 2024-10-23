package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.CartDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.exception.CartException;
import com.actumdigital.skoda_demo.mapper.CartItemMapper;
import com.actumdigital.skoda_demo.mapper.CartMapper;
import com.actumdigital.skoda_demo.mapper.ProductMapper;
import com.actumdigital.skoda_demo.model.Cart;
import com.actumdigital.skoda_demo.model.CartItem;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.repository.CartRepository;
import com.actumdigital.skoda_demo.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper, ProductMapper productMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }

    @Override
    public CartDto getActiveCart(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        return cartRepository.findByUser(user)
                .map(cartMapper::toDto)
                .orElse(null);
    }

    @Override
    public CartDto removeProductFromCart(ProductDto productDto, User user) {
        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> CartException.NOT_FOUND);

        List<CartItem> items = cart.getItems();

        if (!CollectionUtils.isEmpty(items)) {
            items.removeIf(item -> item.getProduct().getCode().equals(productDto.getCode()));
            saveCart(cart);
        }

        return cartMapper.toDto(cart);
    }

    @Override
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public CartDto addProductToCart(ProductDto productDto, User user) {
        Cart cart = getOrCreateCart(user);
        CartItem cartItem = new CartItem(cart, productMapper.toModel(productDto));

        cart.addItem(cartItem);

        return cartMapper.toDto(saveCart(cart));
    }



    private Cart getOrCreateCart(User user) {
        return cartRepository.findByUser(user)
                .orElseGet(() -> cartRepository.save(new Cart(0.0, user)));
    }

    private Cart saveCart(Cart cart) {
        cart.setTotalPrice(cart.getItems().stream()
                .mapToDouble(i -> i.getProduct().getPrice())
                .sum());
        return cartRepository.save(cart);
    }
}
