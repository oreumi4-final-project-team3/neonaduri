package com.est.neonaduri.users.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @Column(name="USER_ID", updatable = false,length = 100)
    private String userId;

    @Column(name="USER_NAME",nullable = false,length=20)
    private String userName;

    @Column(name="USER_EMAIL", nullable=false)
    private String userEmail;

    @Column(name="USER_PW", nullable=false)
    private String userPw;

    @Column(name="USER_REGION",nullable = false,length=20)
    private String userRegion;

    @Column(name="USER_BIRTH",nullable = false)
    private LocalDateTime userBirth;

    @Column(name="USER_GENDER",nullable = false,length=10)
    private String userGender;

}

/*
 * 사용자 세부정보(추가 기능) 엔터티 추가 예정
 *
 * @author : Lee Ha Young
 * */
