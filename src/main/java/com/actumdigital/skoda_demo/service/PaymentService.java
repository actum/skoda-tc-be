package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.CreditCardDto;
import com.actumdigital.skoda_demo.enums.PaymentStatus;
import com.adyen.service.exception.ApiException;

import java.io.IOException;

public interface PaymentService {

    PaymentStatus processPayment(Double totalAmount, CreditCardDto creditCard, Long orderId) throws IOException, ApiException;

}
