package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.model.PurchasedLicense;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchasedLicenseMapper {

    @Mapping(target = "email", source = "user.username")
    @Mapping(target = "productCode", source = "product.code")
    PurchasedLicenseDto toDto(PurchasedLicense purchasedLicense);
}
