package com.est.neonaduri.domain.users.controller;

import com.est.neonaduri.domain.userDetails.dto.UserDetailsRequestDto;
import com.est.neonaduri.domain.userDetails.service.UserDetailsService;
import com.est.neonaduri.domain.users.dto.UserDTO;
import com.est.neonaduri.domain.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    /**
     *  userId 별로 모든 정보 조회 - JSON 데이터 확인용 - @RestController
     *
     * @return userId의 userData
     * @author lhy
     */
//    @GetMapping("api/users/{userId}")
//    public UserDTO getUserById(@PathVariable String userId) {
//        return userService.getUserData(userId);
//    }

    /**
     * UserId 별로 User테이블의 필드만 조회 - @Controller
     *
     * @return mypage view 페이지
     * @author lhy
     */
//    @GetMapping("api/users/{userId}")
//    public String getUserHtml(@PathVariable String userId, Model model) {
//        UserDTO user = userService.getUserData(userId);
//        model.addAttribute("user", user);
//        return "mypage"; // templates 폴더의 mypage.html을 참조합니다.
//    }

    @GetMapping("api/users/{userId}")
    public UserDTO getUserData(@PathVariable String userId) {
        return userService.getUserData(userId);
    }

    @GetMapping("mypage/{userId}")
    public String showMyPage(@PathVariable String userId, Model model) {
        // User 정보 가져오기
        UserDTO userDto = userService.getUserData(userId);

        // UserDetails 정보 가져오기
        UserDetailsRequestDto userDetailsDto = userDetailsService.getUserDetails(userId);

        // 모델에 UserDTO와 UserDetails 객체 추가
        model.addAttribute("user", userDto);
        model.addAttribute("userDetails", userDetailsDto);

        // mypage HTML을 렌더링
        return "mypage";
    }
}