package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.OrderDto;

public interface FraudDetectorService {

    OrderDto evaluateFraudRisk(OrderDto orderDto);

}
