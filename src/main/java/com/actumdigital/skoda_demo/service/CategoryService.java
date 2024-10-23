package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.CategoryDto;

import java.util.Optional;

public interface CategoryService {

    Optional<CategoryDto> getCategoryByName(String name);

}
