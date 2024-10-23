package com.actumdigital.skoda_demo.facade;

import com.actumdigital.skoda_demo.dto.CartDto;
import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.service.CartService;
import com.actumdigital.skoda_demo.service.OrderService;
import com.actumdigital.skoda_demo.service.ProductService;
import com.actumdigital.skoda_demo.service.PurchaseLicenseService;
import com.actumdigital.skoda_demo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacade {

    private final OrderService orderService;
    private final ProductService productService;
    private final PurchaseLicenseService purchaseLicenseService;
    private final CartService cartService;

    public OrderFacade(OrderService orderService,
                       ProductService productService,
                       PurchaseLicenseService purchaseLicenseService,
                       CartService cartService) {
        this.orderService = orderService;
        this.productService = productService;
        this.purchaseLicenseService = purchaseLicenseService;
        this.cartService = cartService;
    }

    public OrderDto createOrder(CartDto cartDto, User user) {
        if(cartDto == null) {
            throw new IllegalArgumentException("cartDto cannot be null");
        }
        List<ProductDto> productList = cartDto.getCartItems().stream()
                .map(i -> productService.getProduct(i.getCode()))
                .toList();
        OrderDto createdOrder = orderService.createOrder(user, productList);

        purchaseLicenseService.createPurchasedLicense(user, productList.get(0));

        cartService.deleteCart(cartDto.getId());
        return createdOrder;
    }
}
