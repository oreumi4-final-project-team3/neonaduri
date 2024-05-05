package com.est.neonaduri.domain.posts.repository;

import java.util.List;

import com.est.neonaduri.domain.posts.domain.Posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts,String> {
	Page<Posts> findBypostCategory(String postCategory, Pageable pageable);
}
