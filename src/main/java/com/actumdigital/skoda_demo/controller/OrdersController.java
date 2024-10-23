package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.dto.CartDto;
import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.facade.CartFacade;
import com.actumdigital.skoda_demo.facade.OrderFacade;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(OrdersController.BASE_URL)
public class OrdersController {

    public static final String BASE_URL = "/orders";

    private final CartFacade cartFacade;
    private final OrderFacade orderFacade;

    public OrdersController(CartFacade cartFacade, OrderFacade orderFacade) {
        this.cartFacade = cartFacade;
        this.orderFacade = orderFacade;
    }

    @PostMapping
    public OrderDto createOrder(@AuthenticationPrincipal User user) {
        CartDto cart = cartFacade.getActiveCart(user);
        return orderFacade.createOrder(cart, user);
    }

}
