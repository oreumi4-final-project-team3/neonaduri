package com.est.neonaduri.users;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class domain {
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
