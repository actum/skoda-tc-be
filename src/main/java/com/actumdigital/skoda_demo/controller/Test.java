package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.aws.FraudDetectorResponse;
import com.actumdigital.skoda_demo.payment.PaymentRequestData;
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.model.checkout.CheckoutPaymentMethod;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.service.checkout.PaymentsApi;
import com.adyen.service.exception.ApiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.frauddetector.FraudDetectorClient;
import software.amazon.awssdk.services.frauddetector.model.Entity;
import software.amazon.awssdk.services.frauddetector.model.EventVariableSummary;
import software.amazon.awssdk.services.frauddetector.model.GetEventPredictionRequest;
import software.amazon.awssdk.services.frauddetector.model.GetEventPredictionResponse;
import software.amazon.awssdk.services.frauddetector.model.ModelScores;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

@RestController
@RequestMapping("/test")
public class Test {

    private final FraudDetectorClient fraudDetectorClient;
    private final String detectorId;

    public Test(FraudDetectorClient fraudDetectorClient, String detectorId) {
        this.fraudDetectorClient = fraudDetectorClient;
        this.detectorId = detectorId;
    }

    @GetMapping
    public PaymentResponse test(@RequestBody PaymentRequestData requestData) throws IOException, ApiException {
        final String API_key = "AQEnhmfuXNWTK0Qc+iSRkXAtqsCST4JZDJ8QF8IRCM0PlM9ZemX6hSOuEMFdWw2+5HzctViMSCJMYAc=-VAlFZPB1isgJPs0xBd65NG4yZTPbdW7WR+r9H3pvI2Q=-i1iT<w]a7rML7@f<Pr%";

        Client client = new Client(API_key, Environment.TEST);
        PaymentsApi paymentsApi = new PaymentsApi(client);

        // Create PaymentRequest
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setMerchantAccount("ActumDigitalECOM");
        paymentRequest.setPaymentMethod(new CheckoutPaymentMethod(requestData.getCardDetails()));
        paymentRequest.setAmount(requestData.getAmount());
        paymentRequest.setReference("SC_TEST");
//        paymentRequest.channel(PaymentRequest.ChannelEnum.ANDROID);
//        paymentRequest.returnUrl("dasdasdas");

//        Map<String, String> additionalData = new HashMap<>();
//        additionalData.put("allow3DS2", "true");  // Enable 3DS2
//        paymentRequest.setAdditionalData(additionalData);

        // Make a call to the /payments endpoint
        return paymentsApi.payments(paymentRequest);
    }

    @GetMapping("/2")
    public FraudDetectorResponse test2() throws IOException, ApiException {
        Entity entity = Entity.builder()
                .entityId("customer_123")
                .entityType("customer")
                .build();

        GetEventPredictionRequest request = GetEventPredictionRequest.builder()
                .detectorId(detectorId)
                .eventId("x-evt-008")
                .eventTypeName("order")
                .entities(Collections.singletonList(entity))
                .eventVariables(Collections.singletonMap("total_order_price", "1000.0"))
                .eventVariables(Collections.singletonMap("billing_address", "56206"))
                .eventVariables(Collections.singletonMap("email", "test@test.cz"))
//                .eventVariables(Collections.singletonMap("transaction_amount", "1000"))
                .eventTimestamp(ZonedDateTime.now(ZoneId.of("America/New_York")).truncatedTo(ChronoUnit.SECONDS).format(ISO_INSTANT))
                .build();

        final ModelScores modelScores = fraudDetectorClient.getEventPrediction(request).modelScores().stream().findFirst().get();

        return new FraudDetectorResponse(modelScores.scores().get("skoda_demo_model_insightscore"));
    }

}
