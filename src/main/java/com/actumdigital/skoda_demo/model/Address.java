package com.actumdigital.skoda_demo.model;

import com.actumdigital.skoda_demo.enums.AddressType;
import com.actumdigital.skoda_demo.enums.Country;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "addresses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private Integer houseNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postalCode;

    private String companyName;
    private String VAT;

    @OneToOne(mappedBy = "address")
    private User user;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Enumerated(EnumType.STRING)
    private Country country;

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }
}
