package com.est.neonaduri.domain.users.controller;

import com.amazonaws.services.kms.model.NotFoundException;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
public class ProfileUploadController {
    private final UserRepository userRepository; // 추가
    @Autowired // 추가
    public ProfileUploadController(UserRepository userRepository) { // 생성자 추가
        this.userRepository = userRepository;
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId) { // userId 추가
        try {
            // 이미지를 저장할 경로 설정
            String filePath = "/path/to/save/image/" + file.getOriginalFilename();
            // 지정된 경로에 이미지 저장
            file.transferTo(new File(filePath));
            // 이미지 경로를 데이터베이스에 저장
            Users user = userRepository.findByUserId(userId); // userId를 사용하여 사용자를 찾습니다.
            if (user == null) {
                throw new NotFoundException("User not found");
            }
            user.setUserImg(filePath);
            userRepository.save(user);
            // 저장된 이미지의 경로 반환
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
