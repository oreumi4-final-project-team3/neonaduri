package com.est.neonaduri.domain.posts.controller;

import com.est.neonaduri.domain.posts.dto.PostsListDTO;
import com.est.neonaduri.domain.posts.dto.PostSearchCondition;
import com.est.neonaduri.domain.posts.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("api/search")
    public ResponseEntity<List<PostsListDTO>> search(@RequestParam(value = "searchText")PostSearchCondition searchText){
        List<PostsListDTO> searchedPosts = searchService.searchPosts(searchText);
        return ResponseEntity.ok(searchedPosts);
    }
}
