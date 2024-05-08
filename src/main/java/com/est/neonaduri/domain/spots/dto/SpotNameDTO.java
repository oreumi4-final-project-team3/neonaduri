package com.est.neonaduri.domain.spots.dto;

import lombok.Data;

@Data
public class SpotNameDTO {
	private String spotName;
	private String spotId;

	public SpotNameDTO(String spotName,String spotId) {
		this.spotName = spotName;
		this.spotId=spotId;
	}
}
