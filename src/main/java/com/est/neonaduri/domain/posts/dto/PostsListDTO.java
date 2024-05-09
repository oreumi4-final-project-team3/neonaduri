package com.est.neonaduri.domain.posts.dto;

import com.est.neonaduri.domain.companions.dto.CompanionsListDTO;
import com.est.neonaduri.domain.posts.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsListDTO {
    private String postId;
    private String spotName;
    private String writerId;
    private LocalDateTime userBirth;
    private String userGender;
    private String postTitle;
    private String postContent;
    private List<CompanionsListDTO> companions;

    @Builder
    public PostsListDTO(Posts posts) {
        this.postId = posts.getPostId();
        this.spotName = posts.getSpotName();
        this.writerId = posts.getUsers().getUserName();
        this.userBirth = posts.getUsers().getUserBirth();
        this.userGender = posts.getUsers().getUserGender();
        this.postTitle = posts.getPostTitle();
        this.postContent = posts.getPostContent();
    }
}
