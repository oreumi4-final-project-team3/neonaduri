package com.est.neonaduri.domain.posts.controller;

import com.est.neonaduri.domain.posts.dto.PostsListDTO;
import com.est.neonaduri.domain.posts.dto.PostSearchCondition;
import com.est.neonaduri.domain.posts.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

//    @GetMapping("api/search")
//    public ResponseEntity<Map<String, List<PostsListDTO>>> search(@RequestParam(value = "searchText")PostSearchCondition searchText, Model model){
//        Map<String, List<PostsListDTO>> groupedByCategoryResult = searchService.searchPosts(searchText);
//        return ResponseEntity.ok(groupedByCategoryResult);
//    }
    @GetMapping("api/search")
    public String search(@RequestParam(value = "searchText")PostSearchCondition searchText, Model model){
        Map<String, List<PostsListDTO>> groupedByCategoryResult = searchService.searchPosts(searchText);
        model.addAttribute("groupedByCategoryResult", groupedByCategoryResult);
        return "search-result";
    }
}
