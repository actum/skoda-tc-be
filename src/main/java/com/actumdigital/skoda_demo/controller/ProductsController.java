package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.facade.ProductFacade;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ProductsController.BASE_URL)
public class ProductsController {

    public static final String BASE_URL = "/products";

    private final ProductFacade productFacade;

    public ProductsController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping()
    public List<ProductDto> getAllProducts(@AuthenticationPrincipal User user) {
        return productFacade.getAllProducts(user);
    }

    @GetMapping("/{code}")
    public ProductDto getProduct(@PathVariable String code, @AuthenticationPrincipal User user) {
        return productFacade.getUserProduct(code, user);
    }

    @GetMapping("/inactive")
    public List<ProductDto> getInactive(@AuthenticationPrincipal User user) {
        return productFacade.getInactiveProducts(user);
    }

    @GetMapping("/expired")
    public List<ProductDto> getExpired(@AuthenticationPrincipal User user) {
        return productFacade.getExpiredProducts(user);
    }
}
