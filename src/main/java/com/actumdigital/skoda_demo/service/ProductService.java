package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProduct(String code);
}
