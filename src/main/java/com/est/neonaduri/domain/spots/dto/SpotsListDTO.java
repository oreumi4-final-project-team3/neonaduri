package com.est.neonaduri.domain.spots.dto;

import lombok.Data;

@Data
public class SpotsListDTO {

	private String spotAddr;
	private String spotName;
	private String spotImg;
	private String spotOverview;

	public SpotsListDTO(String spotAddr, String spotName, String spotImg, String spotOverview) {
		this.spotAddr=spotAddr;
		this.spotName = spotName;
		this.spotImg = spotImg;
		this.spotOverview = spotOverview;
	}
}
