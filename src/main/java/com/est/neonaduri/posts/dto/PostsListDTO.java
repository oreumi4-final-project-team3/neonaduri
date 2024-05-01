package com.est.neonaduri.posts.dto;

import com.est.neonaduri.posts.domain.Posts;
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
@Builder
public class PostsListDTO {
    private String postSpotName;
    private String writerId;
    private LocalDateTime userBirth;
    private String userGender;
    private String postTitle;
    private String postContent;

    public PostsListDTO(Posts posts) {
        this.postSpotName = posts.getPostSpotName();
        this.writerId = posts.getUsers().getUserName();
        this.userBirth = posts.getUsers().getUserBirth();
        this.userGender = posts.getUsers().getUserGender();
        this.postTitle = posts.getPostTitle();
        this.postContent = posts.getPostContent();
    }
}
