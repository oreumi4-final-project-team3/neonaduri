package com.est.neonaduri.domain.users.service;

import com.est.neonaduri.domain.users.dto.UserDTO;
import com.est.neonaduri.domain.users.repository.UserRepository;
import com.est.neonaduri.domain.users.domain.Users;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserData(String userId) {
        Users user = userRepository.findByUserId(userId); // 사용자 정보 조회
        return convertToDTO(user);
    }

    public String getUserImgByUserId(String userId) {
        Users user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new EntityNotFoundException("User not found with id: " + userId);
        }
        return user.getUserImg();
    }

    private UserDTO convertToDTO(Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserRegion(user.getUserRegion());
        userDTO.setUserBirth(user.getUserBirth());
        userDTO.setUserGender(user.getUserGender());
        return userDTO;
    }

    public UserDTO updateUser(String userId, UserDTO userDto) {
        Users user = userRepository.findByUserId(userId);

        if (user == null) {
            throw new EntityNotFoundException("User not found with id: " + userId);
        }

        // DTO에서 업데이트할 필드만 가져와서 사용자 정보를 업데이트합니다.
        if (userDto.getUserName() != null) {
            user.setUserName(userDto.getUserName());
        }
        if (userDto.getUserEmail() != null) {
            user.setUserEmail(userDto.getUserEmail());
        }
        if (userDto.getUserRegion() != null) {
            user.setUserRegion(userDto.getUserRegion());
        }
        if (userDto.getUserBirth() != null) {
            user.setUserBirth(userDto.getUserBirth());
        }
        if (userDto.getUserGender() != null) {
            user.setUserGender(userDto.getUserGender());
        }

        // 업데이트된 사용자 정보 저장
        userRepository.save(user);

        // 업데이트된 사용자 정보를 DTO로 변환하여 반환
        return userDto;
    }


    public UserDTO createUser(UserDTO userDto) {
        // 새로운 사용자 엔티티 생성
        Users newUser = new Users();
        newUser.setUserId(userDto.getUserId());
        newUser.setUserName(userDto.getUserName());
        newUser.setUserEmail(userDto.getUserEmail());
        newUser.setUserRegion(userDto.getUserRegion());
        newUser.setUserBirth(userDto.getUserBirth());
        newUser.setUserGender(userDto.getUserGender());

        // 새로운 사용자 정보 저장
        Users createdUser = userRepository.save(newUser);

        // 저장된 사용자 정보를 DTO로 변환하여 반환
        return convertToDTO(createdUser);
    }
    
//    사용자 이미지 경로를 Users 테이블의 userImg에 저장
    private static final String UPLOAD_DIRECTORY = "/path/to/upload/directory";

    public String uploadImage(MultipartFile file) {
        try {
            // 업로드 디렉토리에 파일 저장
            String fileName = file.getOriginalFilename();
            String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);

            // 이미지 경로 반환
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
