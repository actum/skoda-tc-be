package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.CategoryDto;
import com.actumdigital.skoda_demo.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CategoryMapper {

    CategoryDto toDto(Category category);

}
