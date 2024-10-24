package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.OrderDto;
import com.actumdigital.skoda_demo.enums.FraudAssessment;

public interface FraudDetectorService {

    OrderDto evaluateFraudRisk(OrderDto orderDto);

}
