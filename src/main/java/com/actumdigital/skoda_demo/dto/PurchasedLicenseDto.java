package com.actumdigital.skoda_demo.dto;

import java.time.LocalDate;

public record PurchasedLicenseDto(LocalDate endDate, UserDto user, ProductDto product) {
}
