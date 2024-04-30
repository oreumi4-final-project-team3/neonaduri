package com.est.neonaduri.spots.dto;

import lombok.Data;

@Data
public class SpotsListDTO {

	private int areaCode;
	private String spotName;
	private String spotImg;
	private String spotOverview;

	public SpotsListDTO(int areaCode, String spotName, String spotImg, String spotOverview) {
		this.areaCode = areaCode;
		this.spotName = spotName;
		this.spotImg = spotImg;
		this.spotOverview = spotOverview;
	}
}
