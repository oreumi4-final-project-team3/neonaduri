package com.est.neonaduri.domain.posts.dto;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostViewResponse {
    private String postId;
    private Users users;
    private String postTitle;
    private String postContent;
    private Integer postView;
    private Integer areaCode;
    private String address;
    private LocalDateTime created;

    public PostViewResponse(Posts post) {
        this.postId = post.getPostId();
        this.users = post.getUsers();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.postView = post.getPostView();
        this.areaCode = post.getAreaCode();
        this.address = post.getAddress();
        this.created = post.getCreated();
    }

}
