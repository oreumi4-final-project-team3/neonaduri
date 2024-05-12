package com.est.neonaduri.global.infra.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.ZSetOperations;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRankResponseDto {
    private String keyword;
    private double score;

    public static SearchRankResponseDto toResponseRankingDto(ZSetOperations.TypedTuple<String> typedTuple) {
        return new SearchRankResponseDto(typedTuple.getValue(), typedTuple.getScore());
    }
}
