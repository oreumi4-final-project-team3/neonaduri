package com.est.neonaduri.domain.spots.repository;

import java.util.List;
import java.util.Optional;

import com.est.neonaduri.domain.spots.domain.Spots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotsRepository extends JpaRepository<Spots,String> {

}