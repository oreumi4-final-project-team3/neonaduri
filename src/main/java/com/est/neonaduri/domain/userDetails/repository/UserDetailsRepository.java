package com.est.neonaduri.domain.userDetails.repository;

import com.est.neonaduri.domain.userDetails.domain.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {

}
