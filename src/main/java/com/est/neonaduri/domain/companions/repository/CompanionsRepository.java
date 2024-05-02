package com.est.neonaduri.domain.companions.repository;

import com.est.neonaduri.domain.companions.domain.Companions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanionsRepository extends JpaRepository<Companions, String> {
}
