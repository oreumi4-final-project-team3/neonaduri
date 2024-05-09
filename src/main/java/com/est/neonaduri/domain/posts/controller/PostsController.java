package com.est.neonaduri.domain.posts.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.companions.dto.CompanionsListDTO;
import com.est.neonaduri.domain.companions.service.CompanionsService;
import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.service.PostImagesService;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostWriteDTO;
import com.est.neonaduri.domain.posts.dto.PostsListDTO;
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
	private final CompanionsService companionsService;
	private final PostImagesService postImagesService;

	@Autowired
	public PostsController(PostsService postsService, PostImagesService postImagesService, CompanionsService companionsService) {
		this.postsService = postsService;
		this.postImagesService = postImagesService;
		this.companionsService = companionsService;
	}

	private PostsListDTO convertToPostsListDTO(Posts posts) {
		return new PostsListDTO(posts);
	}

	/**
	 * 같이갈까? 게시글(Posts)을 생성하는 API
	 *
	 * @return ResponseEntity<Posts> : 같이갈까? 게시글 생성
	 * @author jyh
	 */
	@PostMapping("api/posts/{userId}")
	public ResponseEntity<Posts> createPost(@PathVariable(name = "userId") String userId, @RequestBody PostWriteDTO postWriteDTO) {
		Posts createdPost = postsService.createPost(userId, postWriteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
	}

	/**
	 * 같이갈까? 게시글을 생성하는 API (이미지 저장기능 추가)
	 *
	 * @return ResponseEntity<Posts>
	 * @author cjw
	 */
	@PostMapping("api/posts/img/{userId}")
	public ResponseEntity<Posts> addPost(@PathVariable(name = "userId") String userId,
										 @RequestPart(value = "postRequest") PostWriteDTO postWriteDTO,
										 @RequestPart(value = "img", required = false) MultipartFile file){

		Posts createdPost = postsService.createPost(userId,postWriteDTO);
		try{
			PostImages postImages = postImagesService.uploadImg(file, createdPost);
		} catch(IOException e){
			System.out.println("IMG 등록 실패");
		}

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(createdPost);
	}

	/**
	 * 같이갈까? 게시글 리스트를 조회하는 API
	 *
	 * @return List<Posts> : 같이갈까? 게시글 리스트
	 * @author jyh
	 */
	@GetMapping("api/posts")
	public String getAllposts(Model model) {
		List<PostsListDTO> posts = postsService.getAllPosts();

		for (PostsListDTO post : posts) {
			List<CompanionsListDTO> companions = companionsService.getAllCompanions(post.getPostId());
			post.setCompanions(companions);
		}

		model.addAttribute("posts", posts);

		return "companions";
	}

	@GetMapping("api/reviews")
	public String getAllReview(Model model,
	@RequestParam(defaultValue = "1")int page,
	@RequestParam(defaultValue = "12")int size){
		Pageable pageable = PageRequest.of( Math.max(page-1, 0),size);
		model.addAttribute("reviews",postsService.getAllReviewList(pageable));
		model.addAttribute("currentPage",page);
		model.addAttribute("pageType","all");
		return "reviewList";
	}

	@GetMapping("api/reviews/code/{areaCode}")
	public String getSameAreaReview(@PathVariable int areaCode
		,Model model
		,@RequestParam(defaultValue = "1")int page
		,@RequestParam(defaultValue = "12")int size){

		Pageable pageable = PageRequest.of( Math.max(page-1, 0),size);
		model.addAttribute("reviews",postsService.getReviewListByArea(areaCode,pageable));
		model.addAttribute("currentPage",page);
		model.addAttribute("pageType","region");
		model.addAttribute("areaCode",areaCode);
		return "reviewList";
	}
}
