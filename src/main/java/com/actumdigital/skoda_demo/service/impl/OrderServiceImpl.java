package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.AddressDto;
import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.enums.FraudAssessment;
import com.actumdigital.skoda_demo.enums.PaymentStatus;
import com.actumdigital.skoda_demo.mapper.OrderMapper;
import com.actumdigital.skoda_demo.model.Order;
import com.actumdigital.skoda_demo.model.OrderAddress;
import com.actumdigital.skoda_demo.model.OrderItem;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.repository.OrderRepository;
import com.actumdigital.skoda_demo.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto createOrder(UserDto userDto, List<ProductDto> productList) {
        if (userDto == null) {
            throw new IllegalArgumentException("UserDto cannot be null");
        }

        if (CollectionUtils.isEmpty(productList)) {
            throw new IllegalArgumentException("ProductList must not be empty");
        }

        Order order = new Order();
        List<OrderItem> orderItems = productList.stream()
                .map(p -> new OrderItem(order, new Product(p.getId(), p.getPrice())))
                .toList();
        order.setPaymentStatus(PaymentStatus.UNPAID);

        order.setItemList(orderItems);
        order.setTotalPrice(order.getItemList().stream().mapToDouble(i -> i.getProduct().getPrice()).sum());
        order.setUser(new User(userDto.id(), userDto.email()));
        order.setBillingAddress(createBillingAddress(userDto.address()));
        order.setFraudAssessment(FraudAssessment.HIGH);

        return orderMapper.toDto(orderRepository.saveAndFlush(order));
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        if (orderDto == null) {
            throw new IllegalArgumentException("OrderDto cannot be null");
        }

        return orderRepository.findById(orderDto.getId())
                .map(order -> {
                    order.setPaymentStatus(orderDto.getPaymentStatus());
                    order.setFraudAssessment(orderDto.getFraudAssessment());
                    order.setItemList(new ArrayList<>(order.getItemList()));
                    return orderMapper.toDto(orderRepository.save(order));
                })
                .orElse(orderDto);
    }

    private OrderAddress createBillingAddress(AddressDto addressDto) {
        return Optional.ofNullable(addressDto)
                .map(dto -> {
                    OrderAddress orderAddress = new OrderAddress();
                    orderAddress.setCity(dto.city());
                    orderAddress.setStreet(dto.street());
                    orderAddress.setHouseNumber(dto.houseNumber());
                    orderAddress.setPostalCode(dto.postalCode());
                    return orderAddress;
                })
                .orElse(null);
    }
}
