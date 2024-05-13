package com.est.neonaduri.domain.spots.dto;

import lombok.Data;

@Data
public class SpotNameDTO {
	private String spotName;
	private String spotId;
	private String postId;

	public SpotNameDTO(String spotName, String spotId, String postId) {
		this.spotName = spotName;
		this.spotId = spotId;
		this.postId = postId;
	}
}
