package com.est.neonaduri.users.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPw;
    private String userRegion;
    private LocalDateTime userBirth;
    private String userGender;
}