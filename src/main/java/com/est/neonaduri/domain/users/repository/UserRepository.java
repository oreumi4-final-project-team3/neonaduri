package com.est.neonaduri.domain.users.repository;

import com.est.neonaduri.domain.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {
    Users findByUserId(String userId);

    Optional<Users> findByUserEmail(String userEmail);
}
