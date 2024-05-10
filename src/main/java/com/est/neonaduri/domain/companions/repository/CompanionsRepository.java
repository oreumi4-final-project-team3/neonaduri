package com.est.neonaduri.domain.companions.repository;

import com.est.neonaduri.domain.companions.domain.Companions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanionsRepository extends JpaRepository<Companions, String> {
    Optional<Companions> findByPosts_PostId(String postId);

    Page<Companions> findCompanionsByPosts_PostCategory(String postCategory, Pageable pageable);

    @Query("SELECT c FROM Companions c JOIN c.posts p WHERE p.postCategory = 'companions' ORDER BY p.postView DESC limit 3")
    List<Companions> findHotCompanions();

    @Query("SELECT c FROM Companions c JOIN c.posts p WHERE p.areaCode = :areaCode AND p.postCategory = 'companions'")
    Page<Companions> findCompanionsByAreaCodeAndCategory(@Param("areaCode") int areaCode, Pageable pageable);
}
