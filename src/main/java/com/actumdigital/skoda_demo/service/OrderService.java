package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.dto.UserDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(UserDto userDto, List<ProductDto> productList);

    OrderDto updateOrder(OrderDto orderDto);

}
