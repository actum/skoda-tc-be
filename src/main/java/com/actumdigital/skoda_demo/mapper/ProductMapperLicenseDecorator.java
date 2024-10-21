package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.model.PurchasedLicense;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ProductMapperLicenseDecorator implements ProductMapper {

    private final ProductMapper productMapper;

    public ProductMapperLicenseDecorator(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto toDto(Product product, PurchasedLicense purchasedLicense) {
        ProductDto productDto = productMapper.toDto(product, purchasedLicense);

        if (purchasedLicense != null) {
            return new ProductDto(
                    productDto.code(),
                    productDto.name(),
                    productDto.description(),
                    productDto.price(),
                    purchasedLicense.getEndDate()
            );
        }

        return productDto;
    }
}
