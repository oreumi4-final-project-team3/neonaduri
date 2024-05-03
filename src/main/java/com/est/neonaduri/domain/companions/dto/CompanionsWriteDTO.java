package com.est.neonaduri.domain.companions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanionsWriteDTO {
//    private String postId;
    private Integer comRecruit;
    private LocalDateTime comStart;
    private LocalDateTime comEnd;
}
