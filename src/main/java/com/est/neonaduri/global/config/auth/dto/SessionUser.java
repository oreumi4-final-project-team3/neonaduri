package com.est.neonaduri.global.config.auth.dto;

import com.est.neonaduri.domain.users.domain.Users;

import java.io.Serializable;

public class SessionUser implements Serializable { //인증된 사용자 정보만 들어간다
    private String name;
    private String email;
    private String picture;

    public SessionUser(Users user){
        this.name = user.getUserName();
        this.email = user.getUserEmail();
        this.picture = user.getUserImg();
    }
}
