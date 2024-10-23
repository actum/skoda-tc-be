package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.exception.ProductException;
import com.actumdigital.skoda_demo.mapper.ProductMapper;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.repository.ProductRepository;
import com.actumdigital.skoda_demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto getProduct(String code) {
        Product product = productRepository.findByCode(code).orElseThrow(() -> ProductException.NOT_FOUND);
        return productMapper.toDto(product);
    }
}
