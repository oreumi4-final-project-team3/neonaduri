package com.est.neonaduri.domain.companions.controller;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.dto.AddCompanionsRequest;
import com.est.neonaduri.domain.companions.service.CompanionsService;
import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.service.PostImagesService;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.AddPostRequest;
import com.est.neonaduri.domain.posts.dto.CreatePostDTO;
import com.est.neonaduri.domain.posts.dto.UpdatePostDTO;
import com.est.neonaduri.domain.posts.service.PostsService;
import com.est.neonaduri.domain.wishlist.domain.Wishlist;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompanionsController {
    private final CompanionsService companionsService;
    private final PostsService postsService;
    private final PostImagesService postImagesService;



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

    //CJW
    @PostMapping("api/companions")
    public ResponseEntity<Companions> addCompanions(@RequestPart(value = "data") AddCompanionsRequest request,
                                                    @RequestPart(value = "file", required = false) MultipartFile file){
        //security에서 반환 예정
        String userId = "admin_id";

        Posts newPost = postsService.savePost(request.toPostRequest(),userId);
        Companions newCompanions = companionsService.saveCompanions(request.toCompanionWriteDTO(), newPost);

        try {
            PostImages postImages = postImagesService.uploadImg(file, newPost);
        } catch (IOException e) {
            System.out.println("IMG 등록 실패");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newCompanions);
    }

    //예약후 업데이트
    @PutMapping("/api/companions/{comId}/bookers")
    public ResponseEntity<Companions> afterBook(@PathVariable String comId){
        Companions companion = companionsService.afterBook(comId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(companion);
    }

    //찜 후 업데이트
    @PutMapping("/api/companions/{comId}/wishlist")
    public ResponseEntity<Companions> afterWish(@PathVariable String comId){
        Companions companion = companionsService.afterWish(comId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(companion);
    }

}