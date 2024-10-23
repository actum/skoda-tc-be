package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.OrderItemDto;
import com.actumdigital.skoda_demo.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemDto toDto(OrderItem item) {
        if (item == null) {
            throw new IllegalArgumentException("OrderItem cannot be null");
        }

        return new OrderItemDto(
                item.getProduct().getCode(),
                item.getProduct().getPrice());
    }
}
