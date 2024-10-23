package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.model.Product;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Named("toDto")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDto toDto(Product product);

    @Named("toModel")
    Product toModel(ProductDto productDto);

    @IterableMapping(qualifiedByName = "toModel")
    List<Product> toModel(List<ProductDto> productDtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<ProductDto> toDto(List<Product> productList);
}