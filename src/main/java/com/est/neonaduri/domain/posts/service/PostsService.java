package com.est.neonaduri.domain.posts.service;

import java.util.List;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.dto.CompanionsDTO;
import com.est.neonaduri.domain.companions.dto.CompanionsListDTO;
import com.est.neonaduri.domain.companions.repository.CompanionsRepository;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.AddPostRequest;
import com.est.neonaduri.domain.posts.dto.PostWriteDTO;
import com.est.neonaduri.domain.posts.dto.UpdatePostRequest;
import com.est.neonaduri.domain.spots.dto.SpotsListDTO;
import com.est.neonaduri.domain.posts.dto.PostsListDTO;
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
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostsService {


	private final PostsRepository postsRepository;
	private final SpotsRepository spotsRepository;
	private final UserRepository userRepository;
	private final CompanionsRepository companionsRepository;
	@Autowired
	public PostsService(PostsRepository postsRepository, SpotsRepository spotsRepository,UserRepository userRepository, CompanionsRepository companionsRepository) {
		this.postsRepository = postsRepository;
		this.spotsRepository = spotsRepository;
		this.userRepository = userRepository;
		this.companionsRepository = companionsRepository;
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
	public Page<CompanionsListDTO> getAllPosts(Pageable pageable) {
		Page<Companions> companions = companionsRepository.findCompanionsByPosts_PostCategory("companions", pageable);

		List<CompanionsListDTO> dtoPage = companions.getContent().stream()
				.map(companion -> new CompanionsListDTO(
						companion.getPosts().getUsers().getUserName(),
						companion.getPosts().getUsers().getUserBirth(),
						companion.getPosts().getUsers().getUserGender(),
						companion.getComStart(),
						companion.getComEnd(),
						companion.getPosts().getPostTitle(),
						companion.getPosts().getPostContent(),
                        companion.getComRecruit(),
                        companion.getComWish(),
                        companion.getComReserve()
				))
				.collect(Collectors.toList());

		return new PageImpl<>(dtoPage, pageable, companions.getTotalElements());
	}

	//Read - areaCode
	public Page<CompanionsListDTO> getSameAreaPosts(int areaCode, Pageable pageable) {
		Page<Companions> companions = companionsRepository.findCompanionsByAreaCodeAndCategory(areaCode, pageable);

		List<CompanionsListDTO> dtoList = companions.stream()
				.map(companion -> new CompanionsListDTO(
						companion.getPosts().getUsers().getUserName(),
						companion.getPosts().getUsers().getUserBirth(),
						companion.getPosts().getUsers().getUserGender(),
						companion.getComStart(),
						companion.getComEnd(),
						companion.getPosts().getPostTitle(),
						companion.getPosts().getPostContent(),
						companion.getComRecruit(),
						companion.getComWish(),
						companion.getComReserve()
				)).collect(Collectors.toList());

		return new PageImpl<>(dtoList, pageable, companions.getTotalElements());
	}

	//Read - ONE
	public Posts getPost(String postId){
		return postsRepository.findById(postId).orElseThrow();
	}
	//Update
	public void updatePost(Posts posts){
	}
	//Delete
//	public void deletePost(Posts posts){
//		postsRepository.delete(posts);
//	}

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

	//CJW
	public List<Posts> findAllByCategory(String category){
		return postsRepository.findBypostCategory(category);
	}

	public Posts findById(String id){
		return postsRepository.findByPostId(id);
	}

	public void deletePost(String id){
		postsRepository.deleteById(id);
	}

	@Transactional
	public Posts update(String id, UpdatePostRequest request){
		Posts post = postsRepository.findByPostId(id);
		post.update(request.getTitle(), request.getContent());
		return post;
	}

	public Posts savePost(AddPostRequest request,String userId){
		Users user = userRepository.findByUserId(userId);
		return postsRepository.save(request.toEntity(user));
	}

}
