package com.est.neonaduri.spots.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.est.neonaduri.spots.domain.Spots;
import com.est.neonaduri.spots.dto.SpotsListDTO;

@Repository
public interface SpotsRepository extends JpaRepository<Spots,String> {
	Optional<Spots> findByspotName(String spotName);

	List<Spots> findByAreaCode(int areaCode);
}
