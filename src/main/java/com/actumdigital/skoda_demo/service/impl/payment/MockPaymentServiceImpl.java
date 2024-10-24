package com.actumdigital.skoda_demo.service.impl.payment;

import com.actumdigital.skoda_demo.dto.CreditCardDto;
import com.actumdigital.skoda_demo.enums.PaymentStatus;
import com.actumdigital.skoda_demo.service.PaymentService;
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.CardDetails;
import com.adyen.model.checkout.CheckoutPaymentMethod;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.service.checkout.PaymentsApi;
import com.adyen.service.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Profile("default")
public class MockPaymentServiceImpl implements PaymentService {

    private static final Logger LOG = LoggerFactory.getLogger(MockPaymentServiceImpl.class);

    @Override
    public PaymentStatus processPayment(Double totalAmount, CreditCardDto creditCard, Long orderId) {
        LOG.info("MOCKING PAYMENT");

        return PaymentStatus.PAID;
    }
}
