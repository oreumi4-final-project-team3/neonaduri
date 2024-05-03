package com.est.neonaduri.domain.spots.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.spots.dto.SpotsListDTO;
import com.est.neonaduri.domain.spots.service.SpotsService;

@Controller
public class SpotsController {

	private final SpotsService spotsService;
	@Autowired
	public SpotsController(SpotsService spotsService) {
		this.spotsService = spotsService;
	}

	//데이터 가공 - 게시글 리스트 페이지나 ,인기 게시글 페이지에서 필요한 데이터만 추출
	private SpotsListDTO convertToSpotsListDTO(Spots spots) {
		return new SpotsListDTO(spots.getPosts().getAddress(), spots.getPosts().getSpotName(), spots.getSpotImg(),spots.getPosts().getPostContent());
	}

	/**
	 * 관광지 리스트를 조회하는 API
	 *
	 * @return List<Spots> : 관광지 리스트
	 * @author kec
	 */
	@GetMapping("api/spots")
	public String getAllSpots(Model model){
		model.addAttribute("spots",spotsService.getAllSpots());
		return "here";
	}


	/**
	 * 관광지를 이름으로 조회하는 API
	 *
	 * @return Optional<Spots> : 관광지
	 * @author kec
	 */
	//@GetMapping("api/spots/{spotName}")
	//public Optional<Spots> getSpot(@PathVariable String spotName){
	//	return spotsService.getSpot(spotName);
	//}

	/**
	 * 관광지 지역 코드로 조회하는 API
	 *
	 * @return List<SpotsListDTO> : 관광지 리스트
	 * @author kec
	 */
	@GetMapping("api/spots/code/{areaCode}")
	public String getSameAreaSpot(@PathVariable int areaCode,Model model){
		model.addAttribute("spots",spotsService.getSameAreaSpots(areaCode));
		return "here";
	}

}
