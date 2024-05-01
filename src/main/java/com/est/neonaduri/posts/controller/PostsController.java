package com.est.neonaduri.posts.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.est.neonaduri.posts.domain.Posts;
import com.est.neonaduri.posts.dto.PostsListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.est.neonaduri.posts.service.PostsService;


@RestController
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
}
