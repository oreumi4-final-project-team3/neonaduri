package com.est.neonaduri.domain.users.controller;

import com.est.neonaduri.domain.userDetails.dto.UserDetailsRequestDto;
import com.est.neonaduri.domain.userDetails.service.UserDetailsService;
import com.est.neonaduri.domain.users.dto.UserDTO;
import com.est.neonaduri.domain.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
//    public UserDTO getUserData(@PathVariable String userId) {
//        return userService.getUserData(userId);
//    }

//    사용자 정보 조회 API
    @GetMapping("api/users/{userId}")
    public ResponseEntity<UserDTO> getUserData(@PathVariable String userId) {
        UserDTO userData = userService.getUserData(userId);
        return ResponseEntity.ok(userData);
    }

    // 마이페이지 호출
    @GetMapping("api/mypage/{userId}")
    public String showMyPage(@PathVariable String userId, Model model) {
        // User 정보 가져오기
        UserDTO userDto = userService.getUserData(userId);

        // UserDetails 정보 가져오기
        UserDetailsRequestDto userDetailsDto = userDetailsService.getUserDetailData(userId);

        // 모델에 UserDTO와 UserDetails 객체 추가
        model.addAttribute("user", userDto);
        model.addAttribute("userDetails", userDetailsDto);

        // mypage HTML을 렌더링
        return "mypage";
    }

    // 나의매칭 페이지 호출
    @GetMapping("/myMatching")
    public String showMyMatchingPage() {
        return "myMatching";
    }

    // 로그인 페이지 호출
    @GetMapping("/login")
    public String showLoginPage() { return "login"; }

    // 사용자 정보 수정 API
    @PutMapping("api/users/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String userId, @RequestBody UserDTO userDto) {
        UserDTO updatedUser = userService.updateUser(userId, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    // 사용자 정보 생성 API
    @PostMapping("api/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
        UserDTO createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

//    // 사용자 정보 생성 API
//    @RequestMapping(value = "/api/users/register", method = RequestMethod.POST)
//    public String createUser(@RequestBody UserDTO userDto, Model model) {
//        UserDTO createdUser = userService.createUser(userDto);
//        model.addAttribute("user", createdUser);
//        return "redirect:/api/main"; // 메인으로 이동
//    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDTO userDto,
                           @RequestParam("userGender") String userGender,
                           @RequestParam("userBirth") String userBirthString,
                           @RequestParam("userMbti") String userMbti,
                           @RequestParam("userStyle") String userStyle,
                           @RequestParam("userIntro") String userIntro) {
        // 사용자 정보 생성
        UserDTO newUser = new UserDTO();
        UserDetailsRequestDto userDetailsRequestDto = new UserDetailsRequestDto();

        LocalDateTime userBirth = null;
        if(userBirthString != null && !userBirthString.isEmpty()) {
            // String 값을 LocalDateTime으로 변환
            userBirth = LocalDateTime.parse(userBirthString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }

        newUser.setUserId("admin_id"); // 기존 사용자 아이디
        newUser.setUserEmail("example.com"); // 기존 사용자 이메일
        newUser.setUserName("Admin"); // 기존 사용자 닉네임
        newUser.setUserGender(userGender);
        newUser.setUserBirth(userBirth);
        userDetailsRequestDto.setUserMbti(userMbti);
        userDetailsRequestDto.setUserStyle(userStyle);
        userDetailsRequestDto.setUserIntro(userIntro);

        // 사용자 정보 저장
        UserDTO createdUser = userService.createUser(newUser);

        // 로그인 후 처리 로직 추가 가능

        return "redirect:/neonaduri"; // 로그인 후 메인 페이지로 리다이렉트
    }

}