package com.est.neonaduri.companions.repository;

import com.est.neonaduri.companions.domain.Companions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanionsRepository extends JpaRepository<Companions, String> {
}
