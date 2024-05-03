package com.est.neonaduri.domain.posts.dto;

import com.est.neonaduri.domain.posts.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsListDTO {
    private String spotName;
    private String writerId;
    private LocalDateTime userBirth;
    private String userGender;
    private String postTitle;
    private String postContent;

    @Builder
    public PostsListDTO(Posts posts) {
        this.spotName = posts.getSpotName();
        this.writerId = posts.getUsers().getUserName();
        this.userBirth = posts.getUsers().getUserBirth();
        this.userGender = posts.getUsers().getUserGender();
        this.postTitle = posts.getPostTitle();
        this.postContent = posts.getPostContent();
    }
}
