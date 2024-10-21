package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.model.PurchasedLicense;

public interface ProductMapper {
    ProductDto toDto(Product product, PurchasedLicense purchasedLicense);
}