package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.model.User;

import java.util.Set;
import java.util.UUID;

public interface PurchaseLicenseService {
    PurchasedLicenseDto getPurchasedLicense(User user, ProductDto productDto);

    Set<PurchasedLicenseDto> getAllPurchasedLicensesByUser(User user);

    PurchasedLicenseDto createPurchasedLicense(UUID userId, ProductDto productDto);
}
