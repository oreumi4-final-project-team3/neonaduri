package com.est.neonaduri.domain.companions.controller;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.service.CompanionsService;
import com.est.neonaduri.domain.posts.dto.CreatePostDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("api/post/{userId}")
    public ResponseEntity<Companions> createCompanions(@PathVariable(name = "userId") String userId, @RequestBody CreatePostDTO createPostDTO) {
        log.info("입력된 사용자 : {}",userId);
        Companions createdCompanions = companionsService.createCompanions(userId, createPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompanions);
    }
}