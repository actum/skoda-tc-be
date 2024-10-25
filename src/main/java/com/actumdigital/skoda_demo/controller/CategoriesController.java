package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.dto.CategoryDto;
import com.actumdigital.skoda_demo.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CategoriesController.BASE_URL)
public class CategoriesController {

    public final static String BASE_URL = "/categories";

    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
