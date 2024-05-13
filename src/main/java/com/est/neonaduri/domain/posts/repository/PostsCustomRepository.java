package com.est.neonaduri.domain.posts.repository;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostSearchCondition;

import java.util.List;

public interface PostsCustomRepository {
    List<Posts> search(PostSearchCondition content);
}
