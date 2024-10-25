package com.actumdigital.skoda_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PurchasedLicenseKey implements Serializable {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "product_id")
    private UUID productId;

    public PurchasedLicenseKey(UUID userId, UUID productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public PurchasedLicenseKey() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productCode) {
        this.productId = productCode;
    }
}
