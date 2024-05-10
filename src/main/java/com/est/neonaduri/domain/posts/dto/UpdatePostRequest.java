package com.est.neonaduri.domain.posts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdatePostRequest {
    private String title;
    private String content;
}
