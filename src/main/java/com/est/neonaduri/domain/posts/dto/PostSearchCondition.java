package com.est.neonaduri.domain.posts.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSearchCondition {
    private String searchText;

    @Builder
    public PostSearchCondition(String searchTest){
        this.searchText =searchTest;
    }
}
