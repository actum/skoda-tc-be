package com.actumdigital.skoda_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private String code;

    @Column
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "product")
    private Set<PurchasedLicense> purchasedLicenses;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Set<PurchasedLicense> getPurchasedLicenses() {
        return purchasedLicenses;
    }
}
