package com.actumdigital.skoda_demo.repository;

import com.actumdigital.skoda_demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
