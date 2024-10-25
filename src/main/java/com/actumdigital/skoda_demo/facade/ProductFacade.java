package com.actumdigital.skoda_demo.facade;

import com.actumdigital.skoda_demo.dto.ProductDto;
import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.service.ProductService;
import com.actumdigital.skoda_demo.service.PurchaseLicenseService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    public List<ProductDto> getAllProducts(final User user) {
        final List<ProductDto> allProducts = productService.getAllProducts();
        final Set<PurchasedLicenseDto> purchasedLicenses = purchaseLicenseService.getAllPurchasedLicensesByUser(user);

        final Map<String, PurchasedLicenseDto> licenseMap = purchasedLicenses.stream()
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

    public ProductDto getUserProduct(final String productCode, final User user) {
        final ProductDto product = productService.getProduct(productCode);
        product.setPurchasedLicense(purchaseLicenseService.getPurchasedLicense(user, product));
        return product;
    }

    public List<ProductDto> getInactiveProducts(User user) {
        final List<ProductDto> allProducts = productService.getAllProducts();
        final Set<PurchasedLicenseDto> purchasedLicenses = purchaseLicenseService.getAllPurchasedLicensesByUser(user);

        final Set<String> purchasedProductCodes = purchasedLicenses.stream()
                .map(PurchasedLicenseDto::productCode)
                .collect(Collectors.toSet());

        return allProducts.stream()
                .filter(product -> !purchasedProductCodes.contains(product.getCode()))
                .toList();
    }

    public List<ProductDto> getExpiredProducts(User user) {
        final List<ProductDto> allProducts = productService.getAllProducts();
        final Set<PurchasedLicenseDto> purchasedLicenses = purchaseLicenseService.getAllPurchasedLicensesByUser(user);

        final Set<String> expiredProductCodes = purchasedLicenses.stream()
                .filter(l -> l.endDate().isBefore(LocalDate.now()))
                .map(PurchasedLicenseDto::productCode)
                .collect(Collectors.toSet());

        return allProducts.stream()
                .filter(product -> expiredProductCodes.contains(product.getCode()))
                .toList();
    }
}
