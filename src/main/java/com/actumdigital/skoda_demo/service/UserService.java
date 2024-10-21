package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.dto.PurchasedLicenseDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {

    Set<PurchasedLicenseDto> getPurchasedLicenses(User user);

}
