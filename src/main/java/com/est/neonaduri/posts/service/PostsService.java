package com.est.neonaduri.posts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.neonaduri.posts.domain.Posts;
import com.est.neonaduri.posts.repository.PostsRepository;

@Service
public class PostsService {


	private final PostsRepository postsRepository;
	@Autowired
	public PostsService(PostsRepository postsRepository) {
		this.postsRepository = postsRepository;
	}

	//기본적인 CRUD 관련 코드들 작성
	//Create
	public void createPost(Posts posts){
		postsRepository.save(posts);
	}
	//Read - ALL
	public List<Posts> getAllPosts(){
		return postsRepository.findAll();
	}
	//Read - ONE
	public Posts getPost(String postId){
		return postsRepository.findById(postId).orElseThrow();
	}
	//Update
	public void updatePost(Posts posts){
	}
	//Delete
	public void deletePost(Posts posts){
		postsRepository.delete(posts);
	}
}
