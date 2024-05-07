package com.est.neonaduri.domain.posts.service;

import java.util.List;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostWriteDTO;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.est.neonaduri.domain.posts.dto.ReviewDTO;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.spots.repository.SpotsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;

@Service
public class PostsService {


	private final PostsRepository postsRepository;
	private final SpotsRepository spotsRepository;
	private final UserRepository userRepository;
	@Autowired
	public PostsService(PostsRepository postsRepository, SpotsRepository spotsRepository,UserRepository userRepository) {
		this.postsRepository = postsRepository;
		this.spotsRepository = spotsRepository;
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

	public Page<ReviewDTO> getAllReviewList(Pageable pageable){
		Page<Posts> posts = postsRepository.findBypostCategory("reviews",pageable);

		return posts.map(review->{
			Users users = review.getUsers();
			if(users!=null){
				return new ReviewDTO(null, review.getPostTitle(), review.getSpotName(),review.getUsers().getUserName());
			}
			else{
				return null;
			}
		});

	}
	public Page<ReviewDTO> getReviewListByArea(int areaCode, Pageable pageable) {
		Page<Posts> posts = postsRepository.findReviewsByAreaCodeAndCategory(areaCode, pageable);

		List<ReviewDTO> dtoList = posts.getContent().stream()
			.map(review -> new ReviewDTO(
				null,
				review.getPostTitle(),
				review.getSpotName(),
				review.getUsers().getUserName()))
			.peek(dto -> System.out.println("DTO: " + dto))
			.collect(Collectors.toList());

		return new PageImpl<>(dtoList, pageable, posts.getTotalElements());
	}

}
