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

    public Posts toEntity(Users user) {	// 생성자를 사용해 객체 생성
        return Posts.builder()
                .postTitle(title)
                .postCategory(category)
                .postContent(content)
                .areaCode(15) //수정
                .address("address_test")//수정
                .spotName("spotName_test")//수정
                .users(user)
                .build();
    }
}
