package com.est.neonaduri.domain.posts.dto;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostWriteDTO {
    private String postCategory;
    private String postTitle;
    private String postContent;
    private String spotName;
    private String address;

    public Posts toEntity(Users users) {
        return Posts.builder()
                .postCategory(postCategory)
                .postTitle(postTitle)
                .postContent(postContent)
                .spotName(spotName)
                .address(address)
                .users(users)
                .build();
    }
}
