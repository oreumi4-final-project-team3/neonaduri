package com.est.neonaduri.global.infra.redis;

import com.est.neonaduri.domain.posts.service.SearchService;
import com.est.neonaduri.global.infra.redis.dto.SearchRankResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TempController {
    private final SearchService searchService;

    @GetMapping("api/search-rank")
    public ResponseEntity<List<SearchRankResponseDto>> getSearchRank(){
        List<SearchRankResponseDto> searchRankList = searchService.getSearchRankList();
        return ResponseEntity.ok(searchRankList);
    }

}
