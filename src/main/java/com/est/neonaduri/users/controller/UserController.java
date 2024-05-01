package com.est.neonaduri.users.controller;

import com.est.neonaduri.users.dto.UserDTO;
import com.est.neonaduri.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/mypage")
    public UserDTO myPage(UserDTO userDTO) {
        return userService.getUserData(userDTO.getUserId());
    }
}