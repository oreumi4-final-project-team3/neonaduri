package com.est.neonaduri.domain.posts.service;

import com.est.neonaduri.domain.posts.dto.PostsListDTO;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.posts.dto.PostSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final PostsRepository postsRepository;

    public List<PostsListDTO> searchPosts(PostSearchCondition postSearchCondition){
        return postsRepository.search(postSearchCondition)
                .stream()
                .map(PostsListDTO::new)
                .collect(Collectors.toList());
    }
}
