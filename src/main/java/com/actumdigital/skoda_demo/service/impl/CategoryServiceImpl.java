package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.CategoryDto;
import com.actumdigital.skoda_demo.mapper.CategoryMapper;
import com.actumdigital.skoda_demo.repository.CategoryRepository;
import com.actumdigital.skoda_demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .toList();
    }
}
