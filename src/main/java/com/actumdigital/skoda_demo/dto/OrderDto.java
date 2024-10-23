package com.actumdigital.skoda_demo.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(Long id, List<OrderItemDto> itemList, Double totalPrice, LocalDateTime createdAt) {
}
