package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(ProductsController.BASE_URL)
public class ProductsController {

    public static final String BASE_URL = "/products";

    public ProductsController() {
    }

    @GetMapping("/{code}")
    public ProductDto getProduct(@PathVariable String code) {
        return new ProductDto("PR0001", "product 1", "dasdasdsa", 1999.0, LocalDate.now());
    }
}
