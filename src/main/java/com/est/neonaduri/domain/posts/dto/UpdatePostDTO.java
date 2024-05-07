package com.est.neonaduri.domain.posts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostDTO {
    private String postCategory;
    private String postTitle;
    private String postContent;
    private String spotName;
    private Integer areaCode;
    private String address;
    private Integer comRecruit;
    private LocalDateTime comStart;
    private LocalDateTime comEnd;
}
