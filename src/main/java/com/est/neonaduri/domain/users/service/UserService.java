package com.est.neonaduri.domain.users.service;

import com.est.neonaduri.domain.users.dto.UserDTO;
import com.est.neonaduri.domain.users.repository.UserRepository;
import com.est.neonaduri.domain.users.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserData(String userId) {
        Users user = userRepository.findByUserId(userId); // 사용자 정보 조회
        return convertToDTO(user);
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
}
