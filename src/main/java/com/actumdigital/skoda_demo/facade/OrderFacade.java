package com.actumdigital.skoda_demo.facade;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.dto.OrderEntryDto;
import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.enums.FraudAssessment;
import com.actumdigital.skoda_demo.enums.PaymentStatus;
import com.actumdigital.skoda_demo.service.FraudDetectorService;
import com.actumdigital.skoda_demo.service.OrderService;
import com.actumdigital.skoda_demo.service.PaymentService;
import com.actumdigital.skoda_demo.service.ProductService;
import com.actumdigital.skoda_demo.service.PurchaseLicenseService;
import com.actumdigital.skoda_demo.service.UserService;
import com.adyen.service.exception.ApiException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class OrderFacade {

    private final OrderService orderService;
    private final ProductService productService;
    private final PaymentService paymentService;
    private final PurchaseLicenseService purchaseLicenseService;
    private final UserService userService;
    private final FraudDetectorService fraudDetectorService;

    public OrderFacade(OrderService orderService, ProductService productService, PaymentService paymentService, PurchaseLicenseService purchaseLicenseService, UserService userService, FraudDetectorService fraudDetectorService) {
        this.orderService = orderService;
        this.productService = productService;
        this.paymentService = paymentService;
        this.purchaseLicenseService = purchaseLicenseService;
        this.userService = userService;
        this.fraudDetectorService = fraudDetectorService;
    }

    public OrderDto createOrder(final List<OrderEntryDto> orderEntryDtoList) throws IOException, ApiException {
        UserDto userDto = userService.getCurrentUser();

        List<ProductDto> productList = orderEntryDtoList.stream()
                .map(e -> productService.getProduct(e.code()))
                .toList();

        final OrderDto createdOrder = orderService.createOrder(userDto, productList);
        final OrderDto evaluatedOrderDto = fraudDetectorService.evaluateFraudRisk(createdOrder);

        if (evaluatedOrderDto.getFraudAssessment().equals(FraudAssessment.HIGH)) {
            return orderService.updateOrder(evaluatedOrderDto);
        }

        final PaymentStatus paymentStatus = paymentService.processPayment(evaluatedOrderDto.getTotalPrice(), userDto.creditCard(), evaluatedOrderDto.getId());

        if (paymentStatus.equals(PaymentStatus.PAID)) {
            evaluatedOrderDto.setPaymentStatus(PaymentStatus.PAID);
            OrderDto paidOrder = orderService.updateOrder(evaluatedOrderDto);
            productList.forEach(p -> purchaseLicenseService.createPurchasedLicense(userDto.id(), p));
            return paidOrder;
        }

        return createdOrder;
    }
}
