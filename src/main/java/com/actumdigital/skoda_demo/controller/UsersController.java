package com.actumdigital.skoda_demo.controller;

import com.actumdigital.skoda_demo.dto.UserDto;
import com.actumdigital.skoda_demo.model.User;
import com.actumdigital.skoda_demo.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UsersController.BASE_URL)
public class UsersController {

    public static final String BASE_URL = "/users";

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }

}
