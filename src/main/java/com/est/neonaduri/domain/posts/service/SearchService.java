package com.est.neonaduri.domain.posts.service;

import com.est.neonaduri.domain.posts.dto.PostsListDTO;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.posts.dto.PostSearchCondition;
import com.est.neonaduri.global.infra.redis.dto.SearchRankResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final PostsRepository postsRepository;
    private final RedisTemplate<String,String> redisTemplate;

    public List<PostsListDTO> searchPosts(PostSearchCondition postSearchCondition){
        redisTemplate.opsForZSet().incrementScore("ranking",postSearchCondition.getSearchText(),1);
        return postsRepository.search(postSearchCondition)
                .stream()
                .map(PostsListDTO::new)
                .collect(Collectors.toList());
    }

    public List<SearchRankResponseDto> getSearchRankList(){
        String key="ranking";
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> typedTuples = zSetOperations.reverseRangeWithScores(key, 0, 9);
        return typedTuples.stream().map(SearchRankResponseDto::toResponseRankingDto).collect(Collectors.toList());
    }
}
