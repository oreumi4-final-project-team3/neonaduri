package com.est.neonaduri.spots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.neonaduri.spots.domain.Spots;
import com.est.neonaduri.spots.repository.SpotsRepository;

@Service
public class SpotsService {

	private final SpotsRepository spotsRepository;
	@Autowired
	public SpotsService(SpotsRepository spotsRepository) {
		this.spotsRepository = spotsRepository;
	}

	//기본적인 CRUD 관련 코드들 작성

	public void createSpot(Spots spots){
		spotsRepository.save(spots);
	}
	public List<Spots> getAllSpots(){
		return spotsRepository.findAll();
	}
	public Spots getSpot(String spotId){
		return spotsRepository.findById(spotId).orElseThrow();
	}

	public void deleteSpot(Spots spots){
		spotsRepository.delete(spots);
	}
}
