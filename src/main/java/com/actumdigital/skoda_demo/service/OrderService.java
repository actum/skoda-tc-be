package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.User;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(User user, List<ProductDto> productList);

}
