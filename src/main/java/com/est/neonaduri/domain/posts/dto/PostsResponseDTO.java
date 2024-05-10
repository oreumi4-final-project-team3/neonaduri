package com.est.neonaduri.domain.posts.dto;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.Data;

@Data
public class PostsResponseDTO {
    private String postId;
    private String postTitle;
    private String spotName;
    private Users user;
    private String imgLink;


    public PostsResponseDTO(Posts post, Users user, String imgLink){
        this.postId = post.getPostId();
        this.postTitle = post.getPostTitle();
        this.spotName = post.getSpotName();

        this.user = user;
        this.imgLink = imgLink;
    }
}
