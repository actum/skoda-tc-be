package com.actumdigital.skoda_demo.facade;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.service.ProductService;
import com.actumdigital.skoda_demo.service.PurchaseLicenseService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductFacade {
    private final ProductService productService;
    private final PurchaseLicenseService purchaseLicenseService;

    public ProductFacade(ProductService productService, PurchaseLicenseService purchaseLicenseService) {
        this.productService = productService;
        this.purchaseLicenseService = purchaseLicenseService;
    }

    public List<ProductDto> getAllProducts(User user) {
        List<ProductDto> allProducts = productService.getAllProducts();
        Set<PurchasedLicenseDto> purchasedLicences = purchaseLicenseService.getAllPurchasedLicensesByUser(user);

        Map<String, PurchasedLicenseDto> licenseMap = purchasedLicences.stream()
                .collect(Collectors.toMap(PurchasedLicenseDto::productCode, license -> license));

        return allProducts.stream()
                .peek(product -> {
                    PurchasedLicenseDto matchingLicense = licenseMap.get(product.getCode());
                    if (matchingLicense != null) {
                        product.setPurchasedLicense(matchingLicense);
                    }
                })
                .toList();
    }

    public ProductDto getUserProduct(String productCode, User user) {
        ProductDto product = productService.getProduct(productCode);
        product.setPurchasedLicense(purchaseLicenseService.getPurchasedLicense(user, product));
        return product;
    }
}
