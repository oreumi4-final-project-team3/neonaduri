package com.est.neonaduri.domain.userDetails.service;

import com.est.neonaduri.domain.userDetails.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
}
