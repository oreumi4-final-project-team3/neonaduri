package com.est.neonaduri.domain.replies.repository;

import com.est.neonaduri.domain.replies.domain.Replies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepliesRepository extends JpaRepository<Replies, String> {
}
