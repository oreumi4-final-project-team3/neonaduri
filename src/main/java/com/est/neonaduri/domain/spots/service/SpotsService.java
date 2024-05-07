package com.est.neonaduri.domain.spots.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.spots.dto.SpotPageDto;
import com.est.neonaduri.domain.spots.dto.SpotsListDTO;
import com.est.neonaduri.domain.spots.repository.SpotsRepository;
import com.est.neonaduri.global.infra.tourapi.config.AreaCode;
import com.est.neonaduri.global.infra.tourapi.config.ContentCode;
import com.est.neonaduri.global.infra.tourapi.dto.TourApiDto;
import com.est.neonaduri.global.infra.tourapi.service.ApiManager;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SpotsService {

	private final SpotsRepository spotsRepository;
	private final ApiManager apiManager;
	private final PostsRepository postsRepository;
	@Autowired
	public SpotsService(SpotsRepository spotsRepository,ApiManager apiManager,PostsRepository postsRepository) {
		this.spotsRepository = spotsRepository;
		this.apiManager=apiManager;
		this.postsRepository=postsRepository;
	}

	//기본적인 CRUD 관련 코드들 작성

	public void createSpot(Spots spots){
		spotsRepository.save(spots);
	}

	public void deleteSpot(Spots spots){
		spotsRepository.delete(spots);
	}


	public List<SpotsListDTO> getAllSpots(){
		List<Spots> spots = spotsRepository.findAll();
		return spots.stream().map(spot->{
			Posts posts = spot.getPosts();
			if(posts!=null && posts.getPostCategory().equals("spots")) {
				return new SpotsListDTO(spot.getPosts().getAddress(), spot.getPosts().getSpotName(), spot.getSpotImg(),
					spot.getPosts().getPostContent());
			}
			else{
				return null;
			}
		}).collect(Collectors.toList());
	}

	public SpotPageDto getSpotPage(String spotId){
		Spots spot = spotsRepository.findById(spotId)
				.orElseThrow(() -> new EntityNotFoundException("해당하는 게시물을 찾을 수 없습니다."));
		return new SpotPageDto(
				spot.getPosts().getSpotName(),
				spot.getPosts().getAddress(),
				spot.getSpotImg(),
				spot.getPosts().getPostContent(),
				spot.getPosts().getAreaCode(),
				spot.getMapX(),
				spot.getMapY());
	}



	public List<SpotsListDTO> getSameAreaSpots(int areaCode){
		List<Spots> spots = spotsRepository.findAll();
		return spots.stream()
		.filter(spot-> spot.getPosts().getAreaCode().equals(areaCode))
		.map(spot->{
			Posts posts = spot.getPosts();
			return new SpotsListDTO(spot.getPosts().getAddress(),spot.getPosts().getSpotName(),spot.getSpotImg(),spot.getPosts().getPostContent());
		}).collect(Collectors.toList());
	}

}
