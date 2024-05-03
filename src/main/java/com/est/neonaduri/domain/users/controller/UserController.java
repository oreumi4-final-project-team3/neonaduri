package com.est.neonaduri.domain.users.controller;

import com.est.neonaduri.domain.users.dto.UserDTO;
import com.est.neonaduri.domain.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*
    userId 별로 모든 정보 조회 - JSON 데이터 확인용
     */
//    @GetMapping("api/users/{userId}")
//    public UserDTO getUserById(@PathVariable String userId) {
//        return userService.getUserData(userId);
//    }

    /*
    userId 별로 모든 정보 조회 - thymeleaf - @RestController
     */
    @GetMapping("api/users/{userId}")
    public String getUserHtml(@PathVariable String userId, Model model) {
        UserDTO user = userService.getUserData(userId);
        model.addAttribute("user", user);
        return "mypage"; // templates 폴더의 mypage.html을 참조합니다.
    }

}