package com.est.neonaduri.domain.companions.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompanionsResponseDTO {
    private String userName;
    private LocalDateTime userBirth;
    private String userGender;
    private LocalDateTime comStart;
    private LocalDateTime comEnd;
    private String postTitle;
    private String postContent;
    //	private String img;
    private Integer comRecruit;
    private Integer comWish;
    private Integer comReserve;


}
