package com.est.neonaduri.domain.posts.service;

import java.util.List;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostWriteDTO;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.neonaduri.domain.posts.repository.PostsRepository;

@Service
public class PostsService {


	private final PostsRepository postsRepository;
	private final UserRepository userRepository;
	@Autowired
	public PostsService(PostsRepository postsRepository, UserRepository userRepository) {
		this.postsRepository = postsRepository;
		this.userRepository = userRepository;
	}

	//기본적인 CRUD 관련 코드들 작성
	//Create
	public Posts createPost(String userId, PostWriteDTO postWriteDTO) {
		// 사용자 ID로 사용자 정보 조회
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID: " + userId));
		return postsRepository.save(postWriteDTO.toEntity(user)) ;
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
