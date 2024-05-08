package com.est.neonaduri.domain.companions.dto;



import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CompanionsDTO {
	private String userName;
	private LocalDateTime userBirth;
	private String userGender;
	private LocalDateTime comStart;
	private LocalDateTime comEnd;
	private String postTitle;
	private String postContent;
	// private String img;

	public CompanionsDTO(String userName, LocalDateTime userBirth, String userGender, LocalDateTime comStart,
		LocalDateTime comEnd, String postTitle, String postContent) {
		this.userName = userName;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.comStart = comStart;
		this.comEnd = comEnd;
		this.postTitle = postTitle;
		this.postContent = postContent;
		// this.img = img;
	}
}
