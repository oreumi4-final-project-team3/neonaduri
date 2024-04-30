package com.est.neonaduri.users.repository;

import com.est.neonaduri.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
    Users findByUserId(String userId);
}
