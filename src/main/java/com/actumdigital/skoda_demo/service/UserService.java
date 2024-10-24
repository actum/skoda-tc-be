package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.model.Product;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {
    UserDto getCurrentUser();
}
