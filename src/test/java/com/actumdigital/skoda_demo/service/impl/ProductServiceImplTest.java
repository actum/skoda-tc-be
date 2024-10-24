package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.mapper.ProductMapper;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.repository.ProductRepository;
import com.actumdigital.skoda_demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    ProductService productService;

    ProductMapper mapper;

    @Mock
    ProductRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mapper = ProductMapper.INSTANCE;

        productService = new ProductServiceImpl(repository, mapper);
    }

    @Test
    void getAllProducts() {
        Product product1 = new Product();
        product1.setId(UUID.fromString("6f4e4a37-36c6-43b2-8666-0b3ff53c7a2c"));

        Product product2 = new Product();
        product1.setId(UUID.fromString("640df035-7874-4f22-afb6-6ad9a8e74f41"));

        Product product3 = new Product();
        product1.setId(UUID.fromString("4492c542-d7f3-40d5-abfb-e37558aeac81"));

        List<Product> productList = List.of(product1, product2, product3);

        when(repository.findAll()).thenReturn(productList);

        List<ProductDto> returnedMeasurements = productService.getAllProducts();

        verify(repository, times(1)).findAll();
        assertEquals(returnedMeasurements.size(), 3);
        assertEquals(returnedMeasurements.get(0).getId(), product1.getId());
        assertEquals(returnedMeasurements.get(1).getId(), product2.getId());
        assertEquals(returnedMeasurements.get(2).getId(), product3.getId());
    }

    @Test
    void getProduct() {
        Product product = new Product();
        product.setId(UUID.fromString("6f4e4a37-36c6-43b2-8666-0b3ff53c7a2c"));
        product.setCode("PR0001");

        when(repository.findByCode(anyString())).thenReturn(Optional.of(product));

        ProductDto returnedDTO = productService.getProduct("PR0001");

        assertEquals(returnedDTO.getId(), product.getId());

        verify(repository, times(1)).findByCode(anyString());
    }
}