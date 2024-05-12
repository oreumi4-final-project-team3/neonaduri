package com.est.neonaduri.domain.userDetails.dto;

import com.est.neonaduri.domain.userDetails.domain.UserDetails;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetailsRequestDto {
    private String userMbti;
    private String userStyle;
    private String userIntro;

    public String getMbti() {
        return userMbti;
    }

    public void setMbti(String mbti) {
        this.userMbti = mbti;
    }

    public String getStyle() {
        return userStyle;
    }

    public void setStyle(String style) {
        this.userStyle = style;
    }

    public String getIntro() {
        return userIntro;
    }

    public void setIntro(String intro) {
        this.userIntro = intro;
    }

    public UserDetails toEntity(Users users){
        return UserDetails.builder()
                .userMbti(userMbti)
                .userStyle(userStyle)
                .userIntro(userIntro)
                .users(users)
                .build();
    }
}
