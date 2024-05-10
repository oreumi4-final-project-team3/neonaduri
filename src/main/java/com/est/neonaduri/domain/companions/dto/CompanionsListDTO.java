package com.est.neonaduri.domain.companions.dto;

import com.est.neonaduri.domain.companions.domain.Companions;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompanionsListDTO {
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

    public CompanionsListDTO(String userName, LocalDateTime userBirth, String userGender, LocalDateTime comStart,
                             LocalDateTime comEnd, String postTitle, String postContent, Integer comRecruit, Integer comWish, Integer comReserve) {
        this.userName = userName;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.comStart = comStart;
        this.comEnd = comEnd;
        this.postTitle = postTitle;
        this.postContent = postContent;
//		this.img = img;
        this.comRecruit = comRecruit;
        this.comWish = comWish;
        this.comReserve = comReserve;
    }
}
