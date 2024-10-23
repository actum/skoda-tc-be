package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        return new ProductDto(
                product.getId(),
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                null
        );
    }

    public Product toModel(ProductDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("productDto cannot be null");
        }

        return new Product(
                dto.getId(),
                dto.getCode(),
                dto.getName(),
                dto.getPrice(),
                dto.getDescription(),
                null
        );
    }
}