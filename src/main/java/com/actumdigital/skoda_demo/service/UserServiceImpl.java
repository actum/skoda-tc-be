package com.actumdigital.skoda_demo.service;

import com.actumdigital.skoda_demo.exception.UserException;
import com.actumdigital.skoda_demo.model.PurchasedLicense;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.repository.PurchasedLicenseRepository;
import com.actumdigital.skoda_demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PurchasedLicenseRepository purchasedLicenseRepository;

    public UserServiceImpl(UserRepository userRepository, PurchasedLicenseRepository purchasedLicenseRepository) {
        this.userRepository = userRepository;
        this.purchasedLicenseRepository = purchasedLicenseRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> UserException.NOT_FOUND);
    }

    @Override
    public Set<PurchasedLicense> getPurchasedLicenses(User user) {
        return purchasedLicenseRepository.findByUser(user);
    }
}
