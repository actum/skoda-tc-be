package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.model.User;

import java.util.Set;

public interface PurchaseLicenseService {
    PurchasedLicenseDto getPurchasedLicense(User user, ProductDto productDto);

    Set<PurchasedLicenseDto> getAllPurchasedLicensesByUser(User user);

    PurchasedLicenseDto createPurchasedLicense(User user, ProductDto productDto);
}
