package com.actumdigital.skoda_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true,nullable = false)
    private String code;

    @Column
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "product")
    private Set<PurchasedLicense> purchasedLicenses;

    public Product() {
    }

    public Product(UUID id,String code, String name, Double price, String description, Set<PurchasedLicense> purchasedLicenses) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.purchasedLicenses = purchasedLicenses;
    }

    public UUID getId() {
        return id;
    }

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

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
