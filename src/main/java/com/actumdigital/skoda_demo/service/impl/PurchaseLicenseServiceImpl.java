package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.exception.PurchasedLicenseException;
import com.actumdigital.skoda_demo.mapper.ProductMapper;
import com.actumdigital.skoda_demo.mapper.PurchasedLicenseMapper;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.model.PurchasedLicense;
import com.actumdigital.skoda_demo.model.PurchasedLicenseKey;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.repository.PurchasedLicenseRepository;
import com.actumdigital.skoda_demo.service.PurchaseLicenseService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PurchaseLicenseServiceImpl implements PurchaseLicenseService {

    private final PurchasedLicenseRepository purchasedLicenseRepository;
    private final ProductMapper productMapper;
    private final PurchasedLicenseMapper purchasedLicenseMapper;


    public PurchaseLicenseServiceImpl(PurchasedLicenseRepository purchasedLicenseRepository, ProductMapper productMapper, PurchasedLicenseMapper purchasedLicenseMapper) {
        this.purchasedLicenseRepository = purchasedLicenseRepository;
        this.productMapper = productMapper;
        this.purchasedLicenseMapper = purchasedLicenseMapper;
    }

    @Override
    public PurchasedLicenseDto getPurchasedLicense(User user, ProductDto productDto) {
        if(user == null || productDto == null) {
            throw new IllegalArgumentException("User or productDto cannot be null");
        }
        return purchasedLicenseRepository.findByUserAndProduct(user, new Product(productDto.getId()))
                .map(purchasedLicenseMapper::toDto)
                .orElse(null);
    }


    @Override
    public Set<PurchasedLicenseDto> getAllPurchasedLicensesByUser(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return purchasedLicenseRepository.findByUser(user).stream()
                .map(purchasedLicenseMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public PurchasedLicenseDto createPurchasedLicense(User user, ProductDto productDto) {
        PurchasedLicense purchasedLicense = new PurchasedLicense();
        purchasedLicense.setId(new PurchasedLicenseKey(user.getId(), productDto.getId()));
        purchasedLicense.setUser(user);
        purchasedLicense.setProduct(new Product(productDto.getId()));
        purchasedLicense.setEndDate(LocalDate.now().plusYears(1));

        return purchasedLicenseMapper.toDto(purchasedLicenseRepository.save(purchasedLicense));
    }
}