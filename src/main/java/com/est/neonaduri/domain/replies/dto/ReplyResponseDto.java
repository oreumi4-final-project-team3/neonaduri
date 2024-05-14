package com.est.neonaduri.domain.replies.dto;

import com.est.neonaduri.domain.replies.domain.Replies;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyResponseDto {
    private String replyId;
    private String writerId;
    private String writerName;
    private String userImage;
    private String content;
    private String postId;
    private LocalDateTime created;
    private LocalDateTime modified;

    public static ReplyResponseDto toResponse(Replies replies) {
        return new ReplyResponseDto(
                replies.getReplyId(),
                replies.getUsers().getUserId(),
                replies.getUsers().getUserName(),
                replies.getUsers().getUserImg(),
                replies.getContent(),
                replies.getPosts().getPostId(),
                replies.getCreated(),
                replies.getModified());
    }
}
