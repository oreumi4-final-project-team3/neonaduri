package com.est.neonaduri.domain.spots.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.spots.dto.SpotsListDTO;
import com.est.neonaduri.domain.spots.service.SpotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotsController {
//
//	private final SpotsService spotsService;
//	@Autowired
//	public SpotsController(SpotsService spotsService) {
//		this.spotsService = spotsService;
//	}
//
//	//데이터 가공 - 게시글 리스트 페이지나 ,인기 게시글 페이지에서 필요한 데이터만 추출
//	private SpotsListDTO convertToSpotsListDTO(Spots spots) {
//		return new SpotsListDTO(spots.getAreaCode(), spots.getSpotName(), spots.getSpotImg(),spots.getSpotOverview());
//	}
//
//	/**
//	 * 관광지 리스트를 조회하는 API
//	 *
//	 * @return List<Spots> : 관광지 리스트
//	 * @author kec
//	 */
//	@GetMapping("api/spots")
//	public List<SpotsListDTO> getAllSpots(){
//		return spotsService.getAllSpots().stream().map(this::convertToSpotsListDTO).collect(Collectors.toList());
//	}
//
//	/**
//	 * 관광지를 이름으로 조회하는 API
//	 *
//	 * @return Optional<Spots> : 관광지
//	 * @author kec
//	 */
//	@GetMapping("api/spots/{spotName}")
//	public Optional<Spots> getSpot(@PathVariable String spotName){
//		return spotsService.getSpot(spotName);
//	}
//
//	/**
//	 * 관광지 지역 코드로 조회하는 API
//	 *
//	 * @return List<SpotsListDTO> : 관광지 리스트
//	 * @author kec
//	 */
//	@GetMapping("api/spots/code/{areaCode}")
//	public List<SpotsListDTO> getSameAreaSpot(@PathVariable int areaCode){
//		return spotsService.getSameAreaSpots(areaCode).stream().map(this::convertToSpotsListDTO).collect(Collectors.toList());
//	}
}
