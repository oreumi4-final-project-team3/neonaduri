package com.est.neonaduri.domain.companions.controller;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.service.CompanionsService;
import com.est.neonaduri.domain.posts.dto.CreatePostDTO;
import com.est.neonaduri.domain.posts.dto.UpdatePostDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CompanionsController {
    private final CompanionsService companionsService;

    @Autowired
    public CompanionsController(CompanionsService companionsService) {
        this.companionsService = companionsService;
    }

    /**
     * 같이갈까? 게시글을 생성하는 API
     *
     * @return ResponseEntity<Companions> : 같이갈까? 게시글 생성
     * @author jyh
     */
    @PostMapping("api/posts/companions/{userId}")
    public ResponseEntity<Companions> createCompanions(@PathVariable(name = "userId") String userId, @RequestBody CreatePostDTO createPostDTO) {
        log.info("입력된 사용자 : {}",userId);
        Companions createdCompanions = companionsService.createCompanions(userId, createPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompanions);
    }

    /**
     * 같이갈까? 게시글을 수정하는 API
     *
     * @return ResponseEntity<Companions> : 같이갈까? 게시글 수정
     * @author jyh
     */
    @PutMapping("api/posts/companions/{userId}/{postId}")
    public ResponseEntity<Companions> updateCompanions(@PathVariable(name = "userId") String userId, @PathVariable(name = "postId") String postId,
                                                       @RequestBody UpdatePostDTO updatePostDTO) {
        Companions updatedCompanions = companionsService.updateCompanions(userId, postId, updatePostDTO);
        log.info("수정 게시물 : {}", postId);
        return ResponseEntity.ok().body(updatedCompanions);
    }
}