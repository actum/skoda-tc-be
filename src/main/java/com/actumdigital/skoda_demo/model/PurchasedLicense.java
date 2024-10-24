package com.actumdigital.skoda_demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "purchased_licenses")
public class PurchasedLicense {

    @EmbeddedId
    private PurchasedLicenseKey id;

    @OneToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    LocalDate endDate;

    public PurchasedLicense(PurchasedLicenseKey id, Product product, User user) {
        this.id = id;
        this.product = product;
        this.user = user;
    }

    public PurchasedLicense() { }

    public PurchasedLicenseKey getId() {
        return id;
    }

    public void setId(PurchasedLicenseKey id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
