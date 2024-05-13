package com.est.neonaduri.domain.bookers.repository;

import com.est.neonaduri.domain.bookers.domain.Bookers;
import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookersRepository extends JpaRepository<Bookers, String> {
    Integer countAllByCompanions(Companions companions);
    List<Bookers> findAllByUsers(Users users);
}
