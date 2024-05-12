package com.est.neonaduri.domain.search.repository;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.search.dto.PostSearchCondition;

import java.util.List;

public interface SearchCustomRepository {
    public List<Posts> search(PostSearchCondition content);
}
