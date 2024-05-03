package com.est.neonaduri.domain.userDetails.service;

import com.est.neonaduri.domain.userDetails.domain.UserDetails;
import com.est.neonaduri.domain.userDetails.dto.UserDetailsRequestDto;
import com.est.neonaduri.domain.userDetails.repository.UserDetailsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    public UserDetails saveUserDetails(String userId, UserDetailsRequestDto request){
        Users users = userRepository.findByUserId(userId);
        return userDetailsRepository.save(request.toEntity(users));
    }

    public UserDetails findUserDetails(String userId){
        return userDetailsRepository.findByUsers_UserId(userId);
    }

    public UserDetails updateUserDetails(String userId, UserDetailsRequestDto request){
        UserDetails userDetails = userDetailsRepository.findByUsers_UserId(userId);

        userDetails.update(request);

        return userDetails;
    }
}
