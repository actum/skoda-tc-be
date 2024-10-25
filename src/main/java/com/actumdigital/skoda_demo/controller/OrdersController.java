package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.dto.OrderEntryDto;
import com.actumdigital.skoda_demo.facade.OrderFacade;
import com.adyen.service.exception.ApiException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(OrdersController.BASE_URL)
public class OrdersController {

    public static final String BASE_URL = "/orders";

    private final OrderFacade orderFacade;

    public OrdersController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody List<OrderEntryDto> orderEntryList) throws IOException, ApiException {
        return orderFacade.createOrder(orderEntryList);
    }

}
