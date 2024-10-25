package com.actumdigital.skoda_demo.service.impl;

import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.exception.UserException;
import com.actumdigital.skoda_demo.mapper.UserMapper;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.repository.UserRepository;
import com.actumdigital.skoda_demo.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> UserException.NOT_FOUND);
    }

    @Override
    public UserDto getCurrentUser() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findById(principal.getId())
                .orElseThrow(() -> UserException.NOT_FOUND);
        return userMapper.toDto(currentUser);
    }

    public UserDto updateUser(UUID id, UserDto userDto) {
        Optional<User> maybeUser = userRepository.findById(id);

        if (maybeUser.isPresent()) {
            final User user = maybeUser.get();

            user.setFirstname(userDto.firstname());
            user.setLastname(userDto.lastname());
            user.setPhoneNumber(userDto.phoneNumber());

            return userMapper.toDto(userRepository.save(user));
        } else {
            throw UserException.NOT_FOUND;
        }
    }
}
