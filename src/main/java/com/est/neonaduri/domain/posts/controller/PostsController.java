package com.est.neonaduri.domain.posts.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostWriteDTO;
import com.est.neonaduri.domain.posts.dto.PostsListDTO;
import com.est.neonaduri.domain.posts.dto.ReviewDTO;
import com.est.neonaduri.domain.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostsController {

	private final PostsService postsService;

	@Autowired
	public PostsController(PostsService postsService) {
		this.postsService = postsService;
	}

	private PostsListDTO convertToPostsListDTO(Posts posts) {
		return new PostsListDTO(posts);
	}

	/**
	 * 같이갈까? 게시글을 생성하는 API
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
	public String getAllReview(Model model){
		model.addAttribute("reviews",postsService.getAllReviewList());
		return "reviewList";
	}

	@GetMapping("api/reviews/code/{areaCode}")
	public String getSameAreaReview(@PathVariable int areaCode , Model model){
		model.addAttribute("reviews",postsService.getReviewListByArea(areaCode));
		return "reviewList";
	}
}
