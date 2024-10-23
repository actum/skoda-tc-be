package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.Order;
import com.actumdigital.skoda_demo.model.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final OrderItemMapper orderItemMapper;

    public OrderMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    public OrderDto toDto(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        return new OrderDto(
                order.getId(),
                order.getItems().stream().map(orderItemMapper::toDto).toList(),
                order.getTotalPrice()
        );
    }
}