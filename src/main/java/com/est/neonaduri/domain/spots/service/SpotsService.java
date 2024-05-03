package com.est.neonaduri.domain.spots.service;

import java.util.List;
import java.util.Optional;

import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.global.infra.tourapi.service.ApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.neonaduri.domain.spots.repository.SpotsRepository;

@Service
public class SpotsService {

//	private final SpotsRepository spotsRepository;
//
//	@Autowired
//	public SpotsService(SpotsRepository spotsRepository, ApiManager apiManager) {
//		this.spotsRepository = spotsRepository;
//	}
//
//	//기본적인 CRUD 관련 코드들 작성
//
//	public void createSpot(Spots spots){
//		spotsRepository.save(spots);
//	}
//	public List<Spots> getAllSpots(){
//		return spotsRepository.findAll();
//	}
//	public Optional<Spots> getSpot(String spotName){
//		return spotsRepository.findByspotName(spotName);
//	}
//	public List<Spots> getSameAreaSpots(int areaCode){
//		return spotsRepository.findByAreaCode(areaCode);
//	}
//	public void deleteSpot(Spots spots){
//		spotsRepository.delete(spots);
//	}
//
//

}
