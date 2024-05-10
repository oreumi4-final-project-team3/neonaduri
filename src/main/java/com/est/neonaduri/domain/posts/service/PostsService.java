package com.est.neonaduri.domain.posts.service;

import java.util.List;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.repository.PostImagesRepository;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.AddPostRequest;
import com.est.neonaduri.domain.posts.dto.PostWriteDTO;
import com.est.neonaduri.domain.posts.dto.UpdatePostRequest;
import com.est.neonaduri.domain.posts.dto.PostsListDTO;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.est.neonaduri.domain.posts.dto.ReviewDTO;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
	private final PostsRepository postsRepository;
	private final UserRepository userRepository;
	private final PostImagesRepository postImagesRepository;

	//기본적인 CRUD 관련 코드들 작성
	//Create
	public Posts createPost(String userId, PostWriteDTO postWriteDTO) {
		// 사용자 ID로 사용자 정보 조회
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID: " + userId));
		return postsRepository.save(postWriteDTO.toEntity(user)) ;
	}
	//Read - ALL
	public List<PostsListDTO> getAllPosts() {
		List<Posts> posts = postsRepository.findBypostCategory("post");
		return posts.stream()
				.map(PostsListDTO::new)
				.collect(Collectors.toList());
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

	public Page<ReviewDTO> getPostListByCategory(String category, Pageable pageable){
		Page<Posts> posts = postsRepository.findBypostCategory(category,pageable);

		return posts.map(review->{
			Users users = review.getUsers();
			if(users!=null){
				return new ReviewDTO(findImgLink(review), review.getPostTitle(), review.getSpotName(),review.getUsers().getUserName());
			}
			else{
				return null;
			}
		});

	}
	public Page<ReviewDTO> getPostListByCategoryAndAreaCode(String category, int areaCode, Pageable pageable) {
		//Page<Posts> posts = postsRepository.findReviewsByAreaCodeAndCategory(areaCode, pageable);
		Page<Posts> posts = postsRepository.findAllByPostCategoryAndAreaCode(category,areaCode,pageable);

		List<ReviewDTO> dtoList = posts.getContent().stream()
			.map(review -> new ReviewDTO(
				findImgLink(review),
				review.getPostTitle(),
				review.getSpotName(),
				review.getUsers().getUserName()))
			.peek(dto -> System.out.println("DTO: " + dto))
			.collect(Collectors.toList());

		return new PageImpl<>(dtoList, pageable, posts.getTotalElements());
	}

	//imgLink 반환하는 메소드
	String findImgLink(Posts post){
		PostImages postImage = postImagesRepository.findPostImagesByPosts(post);
		if(postImage != null){
			return postImage.getPostImagesId();
		}
		return null;
	}

	//CJW
	/*
	public List<Posts> findAllByCategory(String category){
		return postsRepository.findBypostCategory(category);
	}

	 */

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
