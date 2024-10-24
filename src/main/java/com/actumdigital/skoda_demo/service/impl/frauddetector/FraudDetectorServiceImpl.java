package com.actumdigital.skoda_demo.service.impl.frauddetector;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.enums.FraudAssessment;
import com.actumdigital.skoda_demo.service.FraudDetectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.frauddetector.FraudDetectorClient;
import software.amazon.awssdk.services.frauddetector.model.Entity;
import software.amazon.awssdk.services.frauddetector.model.GetEventPredictionRequest;
import software.amazon.awssdk.services.frauddetector.model.ModelScores;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Optional;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

@Service
@Profile("cloud")
public class FraudDetectorServiceImpl implements FraudDetectorService {

    private static Logger LOG = LoggerFactory.getLogger(FraudDetectorService.class);

    @Value("${aws.fraud-detector.entity-id}")
    private String entityId;

    @Value("${aws.fraud-detector.entity-type-name}")
    private String entityTypeName;

    @Value("${aws.fraud-detector.event-type}")
    private String eventType;

    @Value("${aws.fraud-detector.score-name}")
    private String scoreName;

    private final FraudDetectorClient fraudDetectorClient;
    private final String detectorId;

    public FraudDetectorServiceImpl(FraudDetectorClient fraudDetectorClient, String detectorId) {
        this.fraudDetectorClient = fraudDetectorClient;
        this.detectorId = detectorId;
    }

    @Override
    public OrderDto evaluateFraudRisk(OrderDto orderDto) {
        ModelScores modelScores = sendToAws(orderDto);

        return Optional.ofNullable(modelScores.scores().get(scoreName))
                .map(s -> {
                    LOG.info(String.format("Fraud score: %s", s));
                    if (s < 301) {
                        orderDto.setFraudAssessment(FraudAssessment.LOW);
                        return orderDto;
                    } else if (s < 701) {
                        orderDto.setFraudAssessment(FraudAssessment.MEDIUM);
                        return orderDto;
                    } else {
                        orderDto.setFraudAssessment(FraudAssessment.HIGH);
                        return orderDto;
                    }
                })
                .orElseGet(() -> orderDto);
    }

    private ModelScores sendToAws(OrderDto orderDto) {
        Entity entity = Entity.builder()
                .entityId(entityId)
                .entityType(entityTypeName)
                .build();

        GetEventPredictionRequest request = GetEventPredictionRequest.builder()
                .detectorId(detectorId)
                .eventId(String.format("x-evt-%s_%s", orderDto.getId(), Instant.now().toEpochMilli()))
                .eventTypeName(eventType)
                .entities(Collections.singletonList(entity))
                .eventVariables(Collections.singletonMap("total_order_price", orderDto.getTotalPrice().toString()))
                .eventVariables(Collections.singletonMap("billing_address", orderDto.getBillingAddress().postalCode()))
                .eventVariables(Collections.singletonMap("email", orderDto.getUser().email()))
                .eventTimestamp(ZonedDateTime.now(ZoneId.of("America/New_York")).truncatedTo(ChronoUnit.SECONDS).format(ISO_INSTANT))
                .build();

        return fraudDetectorClient.getEventPrediction(request).modelScores().stream().findFirst().get();
    }
}
