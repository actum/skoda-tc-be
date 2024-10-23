package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.model.PurchasedLicense;
import org.springframework.stereotype.Component;

@Component
public class PurchasedLicenseMapper {

    public PurchasedLicenseDto toDto(PurchasedLicense purchasedLicense) {
        if (purchasedLicense == null) {
            throw new IllegalArgumentException("Purchased license cannot be null");
        }

        return new PurchasedLicenseDto(
                purchasedLicense.getEndDate(),
                purchasedLicense.getUser().getUsername(),
                purchasedLicense.getProduct().getCode()
        );
    }

}
