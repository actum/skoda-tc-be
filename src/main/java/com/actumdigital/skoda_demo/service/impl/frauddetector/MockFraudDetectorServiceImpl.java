package com.actumdigital.skoda_demo.service.impl.frauddetector;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.enums.FraudAssessment;
import com.actumdigital.skoda_demo.service.FraudDetectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
// Temporarily change due to blocked account by AWS. Addressed to AWS support
//@Profile("default")
@Primary
public class MockFraudDetectorServiceImpl implements FraudDetectorService {

    Logger LOG = LoggerFactory.getLogger(MockFraudDetectorServiceImpl.class);

    @Override
    public OrderDto evaluateFraudRisk(OrderDto orderDto) {
        LOG.info("MOCKING EVALUATION OF FRAUD RISK");
        orderDto.setFraudAssessment(FraudAssessment.MEDIUM);

        return orderDto;
    }
}
