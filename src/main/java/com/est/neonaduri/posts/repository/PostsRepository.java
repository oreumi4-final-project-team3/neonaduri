package com.est.neonaduri.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.est.neonaduri.posts.domain.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts,String> {
}
