package com.actumdigital.skoda_demo.mapper;

import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final AddressMapper addressMapper;

    public UserMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public UserDto toDto(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getAddresses().stream().map(addressMapper::toDto).toList()
        );
    }
}
