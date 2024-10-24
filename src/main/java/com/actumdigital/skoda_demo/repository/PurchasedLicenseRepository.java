package com.actumdigital.skoda_demo.repository;

import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.model.PurchasedLicense;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PurchasedLicenseRepository extends JpaRepository<PurchasedLicense, Long> {
    Set<PurchasedLicense> findByUser(User user);
    Optional<PurchasedLicense> findByUserAndProduct(User user, Product product);
}
