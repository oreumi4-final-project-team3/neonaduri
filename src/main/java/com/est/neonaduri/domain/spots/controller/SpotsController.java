package com.est.neonaduri.domain.spots.controller;

import com.est.neonaduri.domain.spots.dto.SpotPageDto;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.spots.dto.SpotsListDTO;
import com.est.neonaduri.domain.spots.service.SpotsService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class SpotsController {
	private final SpotsService spotsService;
	/**
	 * 관광지 지역 코드로 조회하는 API
	 *
	 * @return List<SpotsListDTO> : 관광지 리스트
	 * @author kec
	 */
	@GetMapping("api/spots/code/{areaCode}")
	public String getSameAreaSpot(@PathVariable int areaCode
			,Model model
			,@RequestParam(defaultValue = "1")int page
			,@RequestParam(defaultValue = "12")int size){

		Pageable pageable = PageRequest.of( Math.max(page-1, 0),size);
		model.addAttribute("spots",spotsService.getSameAreaSpots(areaCode,pageable));
		model.addAttribute("currentPage",page);
		model.addAttribute("pageType","region");
		return "here";
	}

}
