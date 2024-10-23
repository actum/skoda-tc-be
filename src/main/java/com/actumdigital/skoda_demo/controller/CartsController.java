package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.dto.CartDto;
import com.actumdigital.skoda_demo.dto.CartEntryDto;
import com.actumdigital.skoda_demo.facade.CartFacade;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(CartsController.BASE_URL)
@RestController
public class CartsController {

    public static final String BASE_URL = "/carts";

    private final CartFacade cartFacade;

    public CartsController(CartFacade cartFacade) {
        this.cartFacade = cartFacade;
    }

    @GetMapping
    public CartDto getActiveCart(@AuthenticationPrincipal User user) {
        return cartFacade.getActiveCart(user);
    }

    @PostMapping("/add")
    public CartDto addProductToCart(@RequestBody final CartEntryDto cartEntryDto, @AuthenticationPrincipal User user) {
        return cartFacade.addProductToCart(cartEntryDto, user);
    }

    @DeleteMapping("/remove")
    public CartDto removeProduct(@RequestBody final CartEntryDto cartEntryDto, @AuthenticationPrincipal User user) {
        return cartFacade.removeProductFromCart(cartEntryDto, user);
    }
}
