package com.est.neonaduri.domain.spots.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.spots.dto.SpotsListDTO;
import com.est.neonaduri.domain.spots.repository.SpotsRepository;
import com.est.neonaduri.global.infra.tourapi.config.AreaCode;
import com.est.neonaduri.global.infra.tourapi.config.ContentCode;
import com.est.neonaduri.global.infra.tourapi.dto.TourApiDto;
import com.est.neonaduri.global.infra.tourapi.service.ApiManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



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

	public Page<SpotsListDTO> getAllSpots(Pageable pageable) {
		Page<Spots> spots = spotsRepository.findAll(pageable);
		Page<SpotsListDTO> dtoPage = spots.map(spot -> {
			Posts posts = spot.getPosts();
			if (posts != null && posts.getPostCategory().equals("spots")) {
				return new SpotsListDTO(
					posts.getAddress(),
					posts.getSpotName(),
					spot.getSpotImg(),
					posts.getPostContent(),
					spot.getSpotId()
				);
			} else {
				return new SpotsListDTO("", "", "", "","");
			}
		});
		return dtoPage;
	}

	// public Page<SpotsListDTO> getSameAreaSpots(int areaCode, Pageable pageable) {
	// 	Page<Spots> spots = spotsRepository.findAll(pageable);
	//
	// 	List<SpotsListDTO> dtoList = spots.stream()
	// 		.filter(spot -> {
	// 			Posts posts = spot.getPosts();
	// 			return posts != null && // Null 체크 추가
	// 				posts.getAreaCode().equals(areaCode) && // 지역 코드 일치 여부 확인
	// 				"spots".equals(posts.getPostCategory()); // "spots" 카테고리 여부 확인
	// 		})
	// 		.map(spot -> new SpotsListDTO(
	// 			spot.getPosts().getAddress(),
	// 			spot.getPosts().getSpotName(),
	// 			spot.getSpotImg(),
	// 			spot.getPosts().getPostContent()
	// 		))
	// 		.peek(dto -> System.out.println("DTO: " + dto))
	// 		.collect(Collectors.toList());
	//
	// 	return new PageImpl<>(dtoList, pageable, spots.getTotalElements());
	// }


}


