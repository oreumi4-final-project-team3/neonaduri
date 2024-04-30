package com.est.neonaduri.spots.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.est.neonaduri.spots.domain.Spots;

@Repository
public interface SpotsRepository extends JpaRepository<Spots,String> {
}
