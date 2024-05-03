package com.est.neonaduri.domain.posts.dto;

import lombok.Data;

@Data
public class ReviewDTO {
	private String spotImg;
	private String postTitle;
	private String spotName;
	private String userName;

	public ReviewDTO(String spotImg, String postTitle, String spotName, String userName) {
		this.spotImg = spotImg;
		this.postTitle = postTitle;
		this.spotName = spotName;
		this.userName = userName;
	}
}
