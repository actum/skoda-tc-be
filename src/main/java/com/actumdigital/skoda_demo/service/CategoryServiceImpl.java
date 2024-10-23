package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.CategoryDto;
import com.actumdigital.skoda_demo.model.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public Optional<CategoryDto> getCategoryByName(String name) {
        return Optional.empty();
    }
}
