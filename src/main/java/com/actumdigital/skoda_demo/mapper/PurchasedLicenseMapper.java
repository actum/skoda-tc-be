package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.model.PurchasedLicense;

public class PurchasedLicenseMapper {

    public PurchasedLicenseDto toDto(PurchasedLicense purchasedLicense) {
        if (purchasedLicense == null) {
            throw new IllegalArgumentException("Purchased license cannot be null");
        }

        // Map only Product fields, set licenceEndDate to null if PurchasedLicense is not present
        return new PurchasedLicenseDto(
                purchasedLicense.getEndDate(),
                null,
                null
        );
    }

}
