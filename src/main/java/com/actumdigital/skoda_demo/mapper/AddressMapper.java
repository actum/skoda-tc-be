package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.AddressDto;
import com.actumdigital.skoda_demo.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto toDto(Address address);
}
