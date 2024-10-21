package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.model.PurchasedLicense;
import org.springframework.stereotype.Component;

@Component
public class BaseProductMapper implements ProductMapper {

    @Override
    public ProductDto toDto(Product product, PurchasedLicense purchasedLicense) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        // Map only Product fields, set licenceEndDate to null if PurchasedLicense is not present
        return new ProductDto(
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                null
        );
    }
}
