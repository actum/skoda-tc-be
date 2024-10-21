package com.actumdigital.skoda_demo.facade;

import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.service.ProductService;
import com.actumdigital.skoda_demo.service.UserService;

import java.util.List;

public class ProductFacade {
    private final ProductService productService;
    private final UserService userService;

    public ProductFacade(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    public List<Product> getAllProductsIncludingUserLicenses() {
        List<Product> allProducts = productService.getAllProducts();
        userService.getPurchasedLicenses();

    }
}
