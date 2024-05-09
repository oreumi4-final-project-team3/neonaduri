package com.est.neonaduri.domain.posts.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.service.PostImagesService;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.AddPostRequest;
import com.est.neonaduri.domain.posts.dto.PostWriteDTO;
import com.est.neonaduri.domain.posts.dto.PostsListDTO;
import com.est.neonaduri.domain.posts.dto.UpdatePostRequest;
import com.est.neonaduri.domain.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PostsController {

    private final PostsService postsService;
    private final PostImagesService postImagesService;

    @Autowired
    public PostsController(PostsService postsService, PostImagesService postImagesService) {
        this.postsService = postsService;
        this.postImagesService = postImagesService;
    }

    private PostsListDTO convertToPostsListDTO(Posts posts) {
        return new PostsListDTO(posts);
    }

//	/**
//	 * 같이갈까? 게시글을 생성하는 API
//	 *
//	 * @return ResponseEntity<Posts> : 같이갈까? 게시글 생성
//	 * @author jyh
//	 */
//	@PostMapping("api/posts/{userId}")
//	public ResponseEntity<Posts> createPost(@PathVariable(name = "userId") String userId, @RequestBody PostWriteDTO postWriteDTO) {
//		Posts createdPost = postsService.createPost(userId, postWriteDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
//	}


    /**
     * 같이갈까? 게시글 리스트를 조회하는 API
     *
     * @return List<Posts> : 같이갈까? 게시글 리스트
     * @author jyh
     */
    @GetMapping("api/posts")
    public List<PostsListDTO> getAllposts() {
        List<PostsListDTO> postsListDTO = postsService.getAllPosts()
                .stream()
                .map(this::convertToPostsListDTO)
                .collect(Collectors.toList());
        return postsListDTO;
    }

    @GetMapping("api/reviews")
    public String getAllReview(Model model,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);
        model.addAttribute("reviews", postsService.getAllReviewList(pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "all");
        return "reviewList";
    }

    @GetMapping("api/reviews/code/{areaCode}")
    public String getSameAreaReview(@PathVariable int areaCode
            , Model model
            , @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "12") int size) {

        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);
        model.addAttribute("reviews", postsService.getReviewListByArea(areaCode, pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "region");
        model.addAttribute("areaCode", areaCode);
        return "reviewList";
    }

    //CJW

    /**
     * Posts를 생성하는 API
     *
     * @return ResponseEntity<Posts>
     * @author cjw
     */
    @PostMapping("api/posts/img")
    public ResponseEntity<Posts> addPost(@RequestPart(value = "data") PostWriteDTO postWriteDTO,
                                         @RequestPart(value = "file", required = false) MultipartFile file) {

        //Security에서 전달 예정
        String userId = "admin_id";
        Posts createdPost = postsService.createPost(userId, postWriteDTO);
        try {
            PostImages postImages = postImagesService.uploadImg(file, createdPost);
        } catch (IOException e) {
            System.out.println("IMG 등록 실패");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdPost);
    }

    //test
    @PostMapping("/api/posts")
    public ResponseEntity<Posts> addImgPosts(@RequestPart(value = "data") AddPostRequest request,
                                             @RequestPart(value = "file", required = false) MultipartFile file) {
        //security 에서 반환 예정
        String userId = "admin_id";
        //입력 받게 수정
        String category = "review";

        Posts post = postsService.savePost(request, userId);
        try {
            PostImages postImages = postImagesService.uploadImg(file, post);
        } catch (IOException e) {
            System.out.println("IMG 등록 실패");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(post);
    }

    /**
     * Posts를 삭제하는 API
     *
     * @author cjw
     */
    @DeleteMapping("/api/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        postsService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/posts/{id}")
    public ResponseEntity<Posts> updatePost(@PathVariable String id, @RequestBody UpdatePostRequest request) {
        Posts updatedPost = postsService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(updatedPost);
    }


}
