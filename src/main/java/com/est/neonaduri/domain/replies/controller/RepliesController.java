package com.est.neonaduri.domain.replies.controller;

import com.est.neonaduri.domain.replies.domain.Replies;
import com.est.neonaduri.domain.replies.dto.ReplyRequestDto;
import com.est.neonaduri.domain.replies.dto.ReplyResponseDto;
import com.est.neonaduri.domain.replies.service.RepliesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RepliesController {
    private final RepliesService repliesService;


    /**
     * 게시물에 해당하는 댓글리스트 조회
     * @param postId
     * @return
     * @author lsh
     */
    @GetMapping("api/posts/reply/{postId}")
    @ResponseBody
    public ResponseEntity<List<ReplyResponseDto>> getRepliesByPostId(@PathVariable(name = "postId")String postId){
        List<ReplyResponseDto> replies = repliesService.getRepliesByPostId(postId);
        return ResponseEntity.ok(replies);
    }



    /**
     * 댓글 저장 기능
     * @param postId
     * @param replyRequestDto
     * @return
     * @author lsh
     */
    @PostMapping("api/posts/{postId}")
    public ResponseEntity<ReplyResponseDto> saveReply(@PathVariable(name = "postId")String postId,
                                                      @RequestBody  ReplyRequestDto replyRequestDto) {
        String userId="admin_id"; //로그인 구현 시 주입
        Replies replies = repliesService.saveReply(postId, userId, replyRequestDto);
        ReplyResponseDto response = ReplyResponseDto.toResponse(replies);
        return ResponseEntity.ok(response);
    }

    /**
     * 댓글 수정 기능
     * @param postId
     * @param userId
     * @param replyRequestDto
     * @return
     * @author lsh
     */
    @PutMapping("api/posts/{postId}/{replyId}/{userId}")
    public ResponseEntity<ReplyResponseDto> updateReply(@PathVariable(name = "postId")String postId,
                                                        @PathVariable(name = "userId")String userId,
                                                        @PathVariable(name = "replyId")String replyId,
                                                        @RequestBody ReplyRequestDto replyRequestDto){
        Replies replies = repliesService.updateReply(postId, replyId, userId, replyRequestDto);
        ReplyResponseDto response = ReplyResponseDto.toResponse(replies);
        return ResponseEntity.ok(response);
    }

    /**
     * 댓글 삭제 기능
     * @param userId
     * @param replyId
     * @return
     * @author lsh
     */
    @DeleteMapping("api/posts/{replyId}/{userId}")
    public ResponseEntity<?> deleteReply(@PathVariable(name = "userId") String userId,
                                         @PathVariable(name = "replyId") String replyId) {
        String deletedReply = repliesService.deleteReply(userId, replyId);
        return ResponseEntity.ok(Map.of("message", "댓글이 삭제 되었습니다. 댓글 id: " + deletedReply));
    }
}
