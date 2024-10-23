package com.actumdigital.skoda_demo.dto;

import java.util.List;

public record OrderDto(Long id, List<OrderItemDto> itemList, Double totalPrice) {
}
