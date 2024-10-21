package com.actumdigital.skoda_demo.dto;

import java.time.LocalDate;

public record ProductDto(String code, String name, String description, Double price, LocalDate licenceEndDate) {
}
