package com.est.neonaduri.domain.replies.repository;

import com.est.neonaduri.domain.replies.domain.Replies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepliesRepository extends JpaRepository<Replies, String> {
    List<Replies> findByPosts_PostIdOrderByCreated(String postId);
}
