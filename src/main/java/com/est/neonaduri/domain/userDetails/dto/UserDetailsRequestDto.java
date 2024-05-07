package com.est.neonaduri.domain.userDetails.dto;

import com.est.neonaduri.domain.userDetails.domain.UserDetails;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserDetailsRequestDto {
    private String mbti;
    private String style;
    private String intro;

    public UserDetails toEntity(Users users){
        return UserDetails.builder()
                .userMbti(mbti)
                .userStyle(style)
                .userIntro(intro)
                .users(users)
                .build();
    }
}
