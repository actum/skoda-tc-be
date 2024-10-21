package com.actumdigital.skoda_demo.repository;

import com.actumdigital.skoda_demo.model.PurchasedLicense;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PurchasedLicenseRepository extends JpaRepository<PurchasedLicense, Long> {
    Set<PurchasedLicense> findByUser(User user);
}
