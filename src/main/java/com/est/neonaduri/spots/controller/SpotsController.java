package com.est.neonaduri.spots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.est.neonaduri.spots.service.SpotsService;

@RestController
public class SpotsController {

	private final SpotsService spotsService;
	@Autowired
	public SpotsController(SpotsService spotsService) {
		this.spotsService = spotsService;
	}

}
