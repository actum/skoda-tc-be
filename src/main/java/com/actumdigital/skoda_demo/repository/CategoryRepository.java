package com.actumdigital.skoda_demo.repository;

import com.actumdigital.skoda_demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Optional<Category> getCategoryByName(String name);

}
