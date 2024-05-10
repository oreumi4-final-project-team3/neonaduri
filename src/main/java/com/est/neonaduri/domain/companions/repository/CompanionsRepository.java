package com.est.neonaduri.domain.companions.repository;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.spots.domain.Spots;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanionsRepository extends JpaRepository<Companions, String> {
    Optional<Companions> findByPosts_PostId(String postId);

    @Query("SELECT c FROM Companions c JOIN c.posts p WHERE p.postCategory = 'companions' ORDER BY p.postView DESC limit 3")
    List<Companions> findHotCompanions();
}
