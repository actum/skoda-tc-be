package com.actumdigital.skoda_demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public record PurchasedLicenseDto(LocalDate endDate, @JsonIgnore String email, @JsonIgnore String productCode) {
}
