package com.est.neonaduri.domain.posts.dto;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPostRequest {
    private String title;
    private String content;
    private String category;
    private String areaCode;
    private String spotName;
    private String address;

    public Posts toEntity(Users user) {	// 생성자를 사용해 객체 생성
        return Posts.builder()
                .postTitle(title)
                .postCategory(category)
                .postContent(content)
                .areaCode(Integer.parseInt(areaCode))
                .address(address)
                .spotName(spotName)
                .users(user)
                .build();
    }
}
