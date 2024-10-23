package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.mapper.OrderMapper;
import com.actumdigital.skoda_demo.mapper.ProductMapper;
import com.actumdigital.skoda_demo.model.Order;
import com.actumdigital.skoda_demo.model.OrderItem;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.repository.OrderRepository;
import com.actumdigital.skoda_demo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ProductMapper productMapper, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productMapper = productMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto createOrder(User user, List<ProductDto> productList) {
        if (CollectionUtils.isEmpty(productList)) {
            throw new IllegalArgumentException("ProductList must not be empty");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Order order = new Order();
        List<OrderItem> orderItems = productList.stream()
                .map(p -> new OrderItem(order, new Product(p.getId())))
                .toList();

        order.setItemList(orderItems);
        order.setTotalPrice(order.getItemList().stream().mapToDouble(i -> i.getProduct().getPrice()).sum());
        order.setUser(user);

        return orderMapper.toDto(orderRepository.save(order));
    }
}
