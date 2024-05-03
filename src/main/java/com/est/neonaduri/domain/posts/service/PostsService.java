package com.est.neonaduri.domain.posts.service;

import java.util.List;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.posts.domain.Posts;
import org.springframework.beans.factory.annotation.Autowired;
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

	public List<ReviewDTO> getAllReviewList(){
		List<Posts> posts = postsRepository.findBypostCategory("reviews");

		return posts.stream().map(review->{
			Users users = review.getUsers();
			if(users!=null){
				return new ReviewDTO(null, review.getPostTitle(), review.getSpotName(),review.getUsers().getUserName());
			}
			else{
				return null;
			}
		}).collect(Collectors.toList());

	}
	public List<ReviewDTO> getReviewListByArea(int areaCode) {
		List<Posts> posts = postsRepository.findBypostCategory("reviews");

		return posts.stream()
			.filter(review -> review.getAreaCode().equals(areaCode))
			.map(review -> {
				Users users = review.getUsers();
				if (users != null) {
					return new ReviewDTO(null, review.getPostTitle(), review.getSpotName(),
						review.getUsers().getUserName());
				} else {
					return null;
				}
			}).collect(Collectors.toList());

	}
}
