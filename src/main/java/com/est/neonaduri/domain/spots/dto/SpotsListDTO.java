package com.est.neonaduri.domain.spots.dto;

import lombok.Data;

@Data
public class SpotsListDTO {

	private String spotAddr;
	private String spotName;
	private String spotImg;
	private String spotOverview;
	private String spotId;

	public SpotsListDTO(String spotAddr, String spotName, String spotImg, String spotOverview,String spotId) {
		this.spotAddr=spotAddr;
		this.spotName = spotName;
		this.spotImg = spotImg;
		this.spotOverview = spotOverview;
		this.spotId=spotId;
	}
}
