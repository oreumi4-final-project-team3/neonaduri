package com.est.neonaduri.domain.bookers.repository;

import com.est.neonaduri.domain.bookers.domain.Bookers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookersRepository extends JpaRepository<Bookers, String> {
}
