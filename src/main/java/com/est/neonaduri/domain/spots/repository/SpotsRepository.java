package com.est.neonaduri.domain.spots.repository;

import java.util.List;
import java.util.Optional;

import com.est.neonaduri.domain.spots.domain.Spots;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotsRepository extends JpaRepository<Spots,String> {
	Spots findByPosts_PostId(String postId);
	// @Query를 사용한 예시
	@Query("SELECT s FROM Spots s JOIN s.posts p WHERE p.areaCode = :areaCode AND p.postCategory = 'spot'")
	Page<Spots> findSpotsByAreaCodeAndCategory(@Param("areaCode") int areaCode, Pageable pageable);

	@Query("SELECT s FROM Spots s JOIN s.posts p WHERE p.postCategory = 'spot' ORDER BY p.postView DESC limit 4")
	List<Spots> findHotSpots();

	@Query("SELECT s FROM Spots s JOIN s.posts p WHERE p.postCategory = 'spot' ORDER BY p.postView DESC limit 10")
	List<Spots> findToptenSpots();

}
