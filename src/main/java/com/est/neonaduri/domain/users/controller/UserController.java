package com.est.neonaduri.domain.users.controller;

import com.est.neonaduri.domain.users.dto.UserDTO;
import com.est.neonaduri.domain.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("api/users/{userId}")
    public UserDTO getUserById(@PathVariable String userId) {
        return userService.getUserData(userId);
    }

}