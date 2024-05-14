package com.est.neonaduri.domain.spots.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.spots.dto.SpotNameDTO;
import com.est.neonaduri.domain.spots.dto.SpotPageDto;
import com.est.neonaduri.domain.spots.dto.SpotsListDTO;
import com.est.neonaduri.domain.spots.repository.SpotsRepository;
import com.est.neonaduri.global.infra.tourapi.config.AreaCode;
import com.est.neonaduri.global.infra.tourapi.config.ContentCode;
import com.est.neonaduri.global.infra.tourapi.dto.TourApiDto;
import com.est.neonaduri.global.infra.tourapi.service.ApiManager;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SpotsService {

	private final SpotsRepository spotsRepository;
	private final ApiManager apiManager;
	private final PostsRepository postsRepository;

	@Autowired
	public SpotsService(SpotsRepository spotsRepository, ApiManager apiManager, PostsRepository postsRepository) {
		this.spotsRepository = spotsRepository;
		this.apiManager = apiManager;
		this.postsRepository = postsRepository;
	}

	//기본적인 CRUD 관련 코드들 작성

	public void createSpot(Spots spots) {
		spotsRepository.save(spots);
	}

	public void deleteSpot(Spots spots) {
		spotsRepository.delete(spots);
	}

	public Spots getSpot(String spotName){
		return spotsRepository.findBySpotName(spotName);
	}

	public Page<SpotsListDTO> getAllSpots(Pageable pageable) {
		Page<Spots> spots = spotsRepository.findAll(pageable);
		Page<SpotsListDTO> dtoPage = spots.map(spot -> {
			Posts posts = spot.getPosts();
			if (posts != null && posts.getPostCategory().equals("spot")) {
				return new SpotsListDTO(
					posts.getAddress(),
					posts.getSpotName(),
					spot.getSpotImg(),
					posts.getPostContent(),
					spot.getSpotId(),
					posts.getPostId()
				);
			} else {
				return new SpotsListDTO("", "", "", "","","");
			}
		});
		return dtoPage;
	}

	public Page<SpotsListDTO> getSameAreaSpots(int areaCode, Pageable pageable) {
		Page<Spots> spots = spotsRepository.findSpotsByAreaCodeAndCategory(areaCode,pageable);

		List<SpotsListDTO> dtoList = spots.stream()
			.map(spot -> new SpotsListDTO(
				spot.getPosts().getAddress(),
				spot.getPosts().getSpotName(),
				spot.getSpotImg(),
				spot.getPosts().getPostContent(),
				spot.getSpotId(),
				spot.getPosts().getPostId()
			))
			.peek(dto -> System.out.println("DTO: " + dto))
			.collect(Collectors.toList());

		return new PageImpl<>(dtoList, pageable, spots.getTotalElements());
	}

	public List<SpotsListDTO> getHotSpots(){
		List<Spots> spots = spotsRepository.findHotSpots();
		List<SpotsListDTO> dtoList = spots.stream()
			.map(spot -> new SpotsListDTO(
				spot.getPosts().getAddress(),
				spot.getPosts().getSpotName(),
				spot.getSpotImg(),
				spot.getPosts().getPostContent(),
				spot.getSpotId(),
				spot.getPosts().getPostId()
			))
			.collect(Collectors.toList());

		return dtoList;
	}
	public List<SpotNameDTO> getToptenSpots(){
		return spotsRepository.findToptenSpots().stream().map(spot-> new SpotNameDTO(
			spot.getPosts().getSpotName(),
			spot.getSpotId(),
			spot.getPosts().getPostId()
		)).collect(Collectors.toList());
	}

	@Transactional
	public SpotPageDto getSpotPageByPostId(String postId){
		Posts post = postsRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시물을 찾을 수 없습니다."));
		post.setPostView(post.getPostView()+1);
		Spots spot = spotsRepository.findByPosts_PostId(postId);
		return new SpotPageDto(
				post.getSpotName(),
				post.getAddress(),
				spot.getSpotImg(),
				post.getPostContent(),
				post.getAreaCode(),
				spot.getMapX(),
				spot.getMapY());
	}
	public SpotPageDto getSpotPageByName(String spotName){
		Spots spot = spotsRepository.findBySpotName(spotName);
		return new SpotPageDto(
			spot.getPosts().getSpotName(),
			spot.getPosts().getAddress(),
			spot.getSpotImg(),
			spot.getPosts().getPostContent(),
			spot.getPosts().getAreaCode(),
			spot.getMapX(),
			spot.getMapY());
	}
}


