package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.OrderItemDto;
import com.actumdigital.skoda_demo.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "code", source = "product.code")
    OrderItemDto toDto(OrderItem item);

}
