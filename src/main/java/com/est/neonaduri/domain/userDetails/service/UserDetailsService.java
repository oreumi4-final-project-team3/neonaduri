package com.est.neonaduri.domain.userDetails.service;

import com.est.neonaduri.domain.userDetails.domain.UserDetails;
import com.est.neonaduri.domain.userDetails.dto.UserDetailsRequestDto;
import com.est.neonaduri.domain.userDetails.repository.UserDetailsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public UserDetails updateUserDetails(String userId, UserDetailsRequestDto request){
        UserDetails userDetails = userDetailsRepository.findByUsers_UserId(userId);

        userDetails.update(request);

        return userDetails;
    }

    public UserDetailsRequestDto getUserDetails(String userId) {
        UserDetails userDetails = userDetailsRepository.findByUsers_UserId(userId); // 사용자 정보 조회

        // UserDetails 객체가 null인지 확인
        if (userDetails != null) {
            return convertToDTO(userDetails);
        } else {
            // UserDetails 객체가 null인 경우에 대한 처리
            return null; // 또는 적절한 기본값을 반환할 수도 있습니다.
        }
    }

    private UserDetailsRequestDto convertToDTO(UserDetails userDetails) {
        UserDetailsRequestDto userDetailsRequestDto = new UserDetailsRequestDto();
        userDetailsRequestDto.setMbti(userDetails.getUserMbti());
        userDetailsRequestDto.setIntro(userDetails.getUserIntro());
        userDetailsRequestDto.setStyle(userDetails.getUserStyle());
        return userDetailsRequestDto;
    }
}
