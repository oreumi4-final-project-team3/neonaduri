package com.est.neonaduri.posts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.est.neonaduri.posts.service.PostsService;

@RestController

public class PostsController {


	private final PostsService postsService;
	@Autowired
	public PostsController(PostsService postsService) {
		this.postsService = postsService;
	}
}
