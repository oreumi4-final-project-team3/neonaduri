package com.est.neonaduri.domain.users.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private String userId;
    private String userName;
    private String userEmail;
    private String userImg;
    private Integer userRegion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime userBirth;
    private String userGender;
}