package com.actumdigital.skoda_demo.dto;

import com.actumdigital.skoda_demo.enums.FraudAssessment;
import com.actumdigital.skoda_demo.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    private Long id;
    private List<OrderItemDto> itemList;
    private Double totalPrice;
    private OrderAddressDto billingAddress;
    private PaymentStatus paymentStatus;
    private FraudAssessment fraudAssessment;
    private LocalDateTime createdAt;
    private UserDto user;

    public OrderDto(Long id, List<OrderItemDto> itemList,
                    Double totalPrice, OrderAddressDto billingAddress,
                    PaymentStatus paymentStatus,
                    FraudAssessment fraudAssessment,
                    LocalDateTime createdAt,
                    UserDto user) {
        this.id = id;
        this.itemList = itemList;
        this.totalPrice = totalPrice;
        this.billingAddress = billingAddress;
        this.paymentStatus = paymentStatus;
        this.fraudAssessment = fraudAssessment;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItemDto> itemList) {
        this.itemList = itemList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderAddressDto getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(OrderAddressDto billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public FraudAssessment getFraudAssessment() {
        return fraudAssessment;
    }

    public void setFraudAssessment(FraudAssessment fraudAssessment) {
        this.fraudAssessment = fraudAssessment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
