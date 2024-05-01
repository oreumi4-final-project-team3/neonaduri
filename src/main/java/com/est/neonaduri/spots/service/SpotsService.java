package com.est.neonaduri.spots.service;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.est.neonaduri.spots.config.ApiConst;
import com.est.neonaduri.spots.config.AreaCode;
import com.est.neonaduri.spots.config.ContentCode;
import com.est.neonaduri.spots.dto.TourApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.neonaduri.spots.domain.Spots;
import com.est.neonaduri.spots.dto.SpotsListDTO;
import com.est.neonaduri.spots.repository.SpotsRepository;

@Service
public class SpotsService {

	private final SpotsRepository spotsRepository;
	private final ApiManager apiManager;
	@Autowired
	public SpotsService(SpotsRepository spotsRepository,ApiManager apiManager) {
		this.spotsRepository = spotsRepository;
		this.apiManager=apiManager;
	}

	//기본적인 CRUD 관련 코드들 작성

	public void createSpot(Spots spots){
		spotsRepository.save(spots);
	}
	public List<Spots> getAllSpots(){
		return spotsRepository.findAll();
	}
	public Optional<Spots> getSpot(String spotName){
		return spotsRepository.findByspotName(spotName);
	}
	public List<Spots> getSameAreaSpots(int areaCode){
		return spotsRepository.findByAreaCode(areaCode);
	}
	public void deleteSpot(Spots spots){
		spotsRepository.delete(spots);
	}


	public void saveSpots(){
		List<List<String>> totalDomesticList=new ArrayList<>();
		for(int areaCode: AreaCode.getAllAreaCodes()){
			List<String> areaBasedcontentIdList = apiManager.fetchByAreaBased(5, areaCode, ContentCode.SPOT);
			totalDomesticList.add(areaBasedcontentIdList);
		}

		for(List<String> areaList:totalDomesticList){
			for(String contentId:areaList){
				List<TourApiDto> commonInfoList = apiManager.fetchByCommonInfo(contentId, ContentCode.SPOT);
				for(TourApiDto dto:commonInfoList){
					Spots spot = dto.toEntity();
					spotsRepository.save(spot);
				}
			}
		}
	}
}
