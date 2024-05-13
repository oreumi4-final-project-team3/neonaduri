package com.est.neonaduri.domain.companions.dto;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CompanionsResponseDTO {
    private String userName;
    private LocalDateTime userBirth;
    private String userGender;

    private String postTitle;
    private String postContent;
    private String imgLink;
    //	private String img;
    private String comId;
    private LocalDate comStart;
    private LocalDate comEnd;
    private Integer comRecruit;
    private Integer comWish;
    private Integer comReserve;

    public CompanionsResponseDTO(Companions companion, Posts post, Users user, String imgLink){
        //user
        this.userName = user.getUserName();
        this.userBirth = user.getUserBirth();
        this.userGender = user.getUserGender();
        //post
        this.postTitle = post.getPostTitle();
        this.postContent=post.getPostContent();
        this.imgLink = imgLink;
        //companion
        this.comId = companion.getCompanionId();
        this.comStart = companion.getComStart();
        this.comEnd = companion.getComEnd();
        this.comRecruit = companion.getComRecruit();
        this.comWish = companion.getComWish();
        this.comReserve = companion.getComReserve();
    }


}
