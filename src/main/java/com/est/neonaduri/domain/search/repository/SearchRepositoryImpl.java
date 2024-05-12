package com.est.neonaduri.domain.search.repository;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.search.dto.PostSearchCondition;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SearchRepositoryImpl implements SearchCustomRepository {
    private  final JPAQueryFactory queryFactory;
    public SearchRepositoryImpl(EntityManager em){
        this.queryFactory=new JPAQueryFactory(em);
    }

    @Override
    public List<Posts> search(PostSearchCondition content) {
        return null;
    }
}
