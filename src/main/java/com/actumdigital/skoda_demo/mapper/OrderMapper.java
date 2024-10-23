package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    OrderDto toDto(Order order);

}