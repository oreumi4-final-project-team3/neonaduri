package com.est.neonaduri.domain.replies.controller;

import com.est.neonaduri.domain.replies.domain.Replies;
import com.est.neonaduri.domain.replies.dto.ReplyRequestDto;
import com.est.neonaduri.domain.replies.service.RepliesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RepliesController {
    private final RepliesService repliesService;

    /**
     * 댓글 저장 기능
     * @param postId
     * @param userId
     * @param replyRequestDto
     * @return
     * @author lsh
     */
    @PostMapping("api/posts/{postId}/{userId}")
    public ResponseEntity<Replies> saveReply(@PathVariable(name = "postId")String postId,
                                             @PathVariable(name = "userId")String userId,
                                             @RequestParam(value = "content") ReplyRequestDto replyRequestDto) {
        Replies replies = repliesService.saveReply(postId, userId, replyRequestDto);
        return ResponseEntity.ok(replies);
    }
    
}
