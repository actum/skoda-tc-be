package com.actumdigital.skoda_demo.model;

import com.actumdigital.skoda_demo.enums.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(unique = true, nullable = false)
    private String code;

    @Column
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "product")
    private Set<PurchasedLicense> purchasedLicenses;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {
    }

    public Product(UUID id) {
        this.id = id;
    }

    public Product(UUID id, String code, String name, Double price, String description, ProductType productType, Category category) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productType = productType;
        this.category = category;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public Set<PurchasedLicense> getPurchasedLicenses() {
        return purchasedLicenses;
    }

    public Category getCategory() {
        return category;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
