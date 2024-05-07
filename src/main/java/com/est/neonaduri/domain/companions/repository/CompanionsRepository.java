package com.est.neonaduri.domain.companions.repository;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanionsRepository extends JpaRepository<Companions, String> {
    Optional<Companions> findByPosts_PostId(String postId);
}
