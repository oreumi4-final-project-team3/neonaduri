package com.est.neonaduri.domain.replies.dto;


import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.replies.domain.Replies;
import com.est.neonaduri.domain.users.domain.Users;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyRequestDto {
    private String content;

    public Replies toEntity(Posts post, Users user){
        return Replies.builder()
                .content(content)
                .users(user)
                .posts(post)
                .build();
    }
}
