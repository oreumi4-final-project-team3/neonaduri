package com.est.neonaduri.domain.companions.dto;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.posts.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanionsWriteDTO {
    private Integer comRecruit;
    private LocalDate comStart;
    private LocalDate comEnd;

    public Companions toEntity(Posts posts) {
        return Companions.builder()
                .comRecruit(comRecruit)
                .comStart(comStart)
                .comEnd(comEnd)
                .posts(posts)
                .build();
    }
}