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
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Primary
//@Profile("cloud")
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Value("${adyen.api-key}")
    private String apiKey;

    @Value("${adyen.merchant-account}")
    private String merchantAccount;

    @Override
    public PaymentStatus processPayment(Double totalAmount, CreditCardDto creditCard, Long orderId) {
        try {
            PaymentResponse paymentResponse = sendPayment(totalAmount, creditCard, orderId);
            return paymentResponse.getResultCode().equals(PaymentResponse.ResultCodeEnum.AUTHORISED) ? PaymentStatus.PAID : PaymentStatus.UNPAID;
        } catch (ApiException | IOException e) {
            LOG.error(e.getMessage());
        }

        return PaymentStatus.UNPAID;
    }

    private PaymentResponse sendPayment(Double totalAmount, CreditCardDto creditCard, Long orderId) throws IOException, ApiException {
        Client client = new Client(apiKey, Environment.TEST);
        PaymentsApi paymentsApi = new PaymentsApi(client);

        Amount amount = new Amount();
        amount.setCurrency("CZK");
        amount.setValue(Math.round(totalAmount));

        CardDetails cardDetails = new CardDetails();
        cardDetails.setType(CardDetails.TypeEnum.SCHEME);
        cardDetails.setEncryptedCardNumber("test_" + creditCard.number());
        cardDetails.setEncryptedExpiryMonth("test_" + creditCard.expiryMonth());
        cardDetails.setEncryptedExpiryYear("test_" + creditCard.expiryYear());
        cardDetails.setEncryptedSecurityCode("test_" + creditCard.cvv());

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setMerchantAccount(merchantAccount);
        paymentRequest.setPaymentMethod(new CheckoutPaymentMethod(cardDetails));
        paymentRequest.setAmount(amount);
        paymentRequest.setReference(String.format("order_%s_%s", orderId, LocalDateTime.now()));

        return paymentsApi.payments(paymentRequest);
    }
}
