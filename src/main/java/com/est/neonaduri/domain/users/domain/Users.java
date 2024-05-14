package com.est.neonaduri.domain.users.domain;

import com.est.neonaduri.global.config.BaseTimeEntity;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class Users extends BaseTimeEntity {
    @Id
    @Column(name="USER_ID", updatable = false,length = 100)
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

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

    @Builder
    public Users(String name, String email, String picture, Role role){
        this.userName = name;
        this.userEmail = email;
        this.userImg = picture;
        this.role = role;
    }

    public Users update(String name, String picture){
        this.userName =name;
        this.userImg = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
