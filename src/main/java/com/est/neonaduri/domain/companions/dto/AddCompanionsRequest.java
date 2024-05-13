package com.est.neonaduri.domain.companions.dto;

import com.est.neonaduri.domain.posts.dto.AddPostRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCompanionsRequest {
    //posts 테이블 저장
    private String title;
    private String content;
    private String category;
    private String areaCode;
    private String spotName;
    private String address;

    //companions 테이블에 저장
    private Integer comRecruit;
    private LocalDate comStart;
    private LocalDate comEnd;

    public AddPostRequest toPostRequest(){
        return AddPostRequest.builder()
                .title(title)
                .content(content)
                .category(category)
                .areaCode(areaCode)
                .spotName(spotName)
                .address(address)
                .build();
    }

    public CompanionsWriteDTO toCompanionWriteDTO(){
        return CompanionsWriteDTO.builder()
                .comRecruit(comRecruit)
                .comStart(comStart)
                .comEnd(comEnd)
                .build();
    }

}
