package com.actumdigital.skoda_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PurchasedLicenseKey implements Serializable {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "product_code")
    private String productCode;

    public PurchasedLicenseKey(UUID userId, String productCode) {
        this.userId = userId;
        this.productCode = productCode;
    }

    public PurchasedLicenseKey() { }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
