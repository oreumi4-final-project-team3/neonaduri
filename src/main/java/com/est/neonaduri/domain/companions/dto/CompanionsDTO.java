package com.est.neonaduri.domain.companions.dto;



import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CompanionsDTO {
	private String userName;
	private LocalDateTime userBirth;
	private String userGender;
	private LocalDate comStart;
	private LocalDate comEnd;
	private String postTitle;
	private String postContent;
	private String imgLink;
	private String comId;

	public CompanionsDTO(String userName, LocalDateTime userBirth, String userGender, LocalDate comStart,
						 LocalDate comEnd, String postTitle, String postContent,String imgLink,String comId) {
		this.userName = userName;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.comStart = comStart;
		this.comEnd = comEnd;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.imgLink = imgLink;
		this.comId = comId;
	}
}
