package com.actumdigital.skoda_demo.dto;

import com.actumdigital.skoda_demo.enums.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class ProductDto {
    @JsonIgnore
    private final UUID id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private PurchasedLicenseDto purchasedLicense;
    private String categoryName;
    private final ProductType productType;


    public ProductDto(UUID id,
                      String code,
                      String name,
                      String description,
                      Double price,
                      ProductType productType,
                      String categoryName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryName = categoryName;
        this.productType = productType;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PurchasedLicenseDto getPurchasedLicense() {
        return purchasedLicense;
    }

    public void setPurchasedLicense(PurchasedLicenseDto purchasedLicense) {
        this.purchasedLicense = purchasedLicense;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductType getProductType() {
        return productType;
    }
}