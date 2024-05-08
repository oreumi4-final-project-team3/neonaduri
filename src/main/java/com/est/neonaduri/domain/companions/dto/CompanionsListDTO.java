package com.est.neonaduri.domain.companions.dto;

import com.est.neonaduri.domain.companions.domain.Companions;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanionsListDTO {
    private String postId;
    private Integer comRecruit;
    private LocalDateTime comStart;
    private LocalDateTime comEnd;

    @Builder
    public CompanionsListDTO(Companions companions) {
        this.postId = companions.getPosts().getPostId();
        this.comRecruit = companions.getComRecruit();
        this.comStart = companions.getComStart();
        this.comEnd = companions.getComEnd();
    }
}
