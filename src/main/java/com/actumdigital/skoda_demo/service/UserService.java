package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService {
    UserDto getCurrentUser();

    UserDto updateUser(UUID id, UserDto userDto);
}
