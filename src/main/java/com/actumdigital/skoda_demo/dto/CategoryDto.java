package com.actumdigital.skoda_demo.dto;

import java.util.List;
import java.util.UUID;

public record CategoryDto(UUID id, String name, List<ProductDto> productList) {
}
