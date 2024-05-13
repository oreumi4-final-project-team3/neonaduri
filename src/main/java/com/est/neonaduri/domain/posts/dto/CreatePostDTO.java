package com.est.neonaduri.domain.posts.dto;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostDTO {
    private String postCategory;
    private String postTitle;
    private String postContent;
    private String spotName;
    private Integer areaCode;
    private String address;
    private Integer comRecruit;
    private LocalDate comStart;
    private LocalDate comEnd;

    public Posts toPostWriteDTO(Users users) {
        return Posts.builder()
                .postCategory(postCategory)
                .postTitle(postTitle)
                .postContent(postContent)
                .areaCode(areaCode)
                .spotName(spotName)
                .address(address)
                .users(users)
                .build();
    }

    public Companions toCompanionsWriteDTO(Posts posts) {
        return Companions.builder()
                .comRecruit(comRecruit)
                .comStart(comStart)
                .comEnd(comEnd)
                .posts(posts)
                .build();
    }
}