package com.est.neonaduri.domain.posts.repository;

import java.util.List;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.spots.domain.Spots;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts,String> {
	Page<Posts> findBypostCategory(String postCategory, Pageable pageable);
	@Query("SELECT p FROM Posts p WHERE p.areaCode = :areaCode AND p.postCategory = 'reviews'")
	Page<Posts> findReviewsByAreaCodeAndCategory(@Param("areaCode") int areaCode, Pageable pageable);
}
