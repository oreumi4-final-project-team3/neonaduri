package com.est.neonaduri.domain.replies.domain;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.global.config.BaseTimeEntity;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="REPLIES")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Replies extends BaseTimeEntity {
    @Id
    @Column(name = "REPLY_ID", length = 100, nullable = false)
    private String replyId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name="POST_ID",nullable = false)
    private Posts posts;

    @Column(name = "CONTENT",length = 100)
    private String content;

    /*
    @PrePersist
    public void prePersist(){
        this.replyId = IdGenerator.generateReplyId(posts.getPostCategory());
    }
     */
}
