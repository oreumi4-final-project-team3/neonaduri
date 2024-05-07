package com.est.neonaduri.domain.users.domain;

import com.est.neonaduri.global.config.BaseTimeEntity;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class Users extends BaseTimeEntity {
    @Id
    @Column(name="USER_ID", updatable = false,length = 100)
    private String userId;

    @Column(name = "USER_ROLE",length = 20)
    private String userRole;

    @Column(name="USER_NAME",nullable = false,length=20)
    private String userName;

    @Column(name="USER_EMAIL", nullable=false)
    private String userEmail;

    @Column(name="USER_IMG")
    private String userImg;

    @Column(name="USER_REGION")
    private Integer userRegion;

    @Column(name="USER_BIRTH")
    private LocalDateTime userBirth;

    @Column(name="USER_GENDER",length=10)
    private String userGender;

    @PrePersist
    public void prePersist(){
        this.userId= IdGenerator.generateUserId();
    }

}

/*
 * 사용자 세부정보(추가 기능) 엔터티 추가 예정
 *
 * @author : Lee Ha Young
 * */
