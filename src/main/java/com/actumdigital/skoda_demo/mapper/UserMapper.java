package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CreditCardMapper.class})
public interface UserMapper {

    @Mapping(target = "email", source = "username")
    UserDto toDto(User user);
}
