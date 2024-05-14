package com.est.neonaduri.domain.userDetails.service;

import com.est.neonaduri.domain.userDetails.domain.UserDetails;
import com.est.neonaduri.domain.userDetails.dto.UserDetailsRequestDto;
import com.est.neonaduri.domain.userDetails.repository.UserDetailsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.dto.UserDTO;
import com.est.neonaduri.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    // 사용자 상세 정보 저장
    public UserDetails saveUserDetails(String userId, UserDetailsRequestDto request){
        Users users = userRepository.findByUserId(userId);
        return userDetailsRepository.save(request.toEntity(users));
    }

    // 사용자 상세 정보 조회
    public UserDetails findUserDetails(String userId){
        return userDetailsRepository.findByUsers_UserId(userId);
    }

    // 사용자 상세 정보 업데이트
    @Transactional
    public UserDetails updateUserDetails(String userId, UserDetailsRequestDto request){
        UserDetails userDetails = userDetailsRepository.findByUsers_UserId(userId);

        userDetails.update(request);

        return userDetails;
    }

    // 사용자 상세 정보 DTO 반환
    public UserDetailsRequestDto getUserDetailData(String userId) {
        UserDetails userDetails = userDetailsRepository.findByUsers_UserId(userId); // 사용자 정보 조회

        // UserDetails 객체가 null인지 확인
        if (userDetails != null) {
            return convertToDTO(userDetails);
        } else {
            // UserDetails 객체가 null인 경우에 대한 처리
            return null; // 또는 적절한 기본값을 반환할 수도 있습니다.
        }
    }

    public UserDetailsRequestDto createUserDetails (UserDetailsRequestDto userDetailsRequestDto) {
        // 새로운 사용자 엔티티 생성
        UserDetails newUserDetails = new UserDetails();
        newUserDetails.setUserMbti(userDetailsRequestDto.getUserMbti());
        newUserDetails.setUserIntro(userDetailsRequestDto.getUserIntro());
        newUserDetails.setUserStyle(userDetailsRequestDto.getUserStyle());

        // 새로운 사용자 정보 저장
        UserDetails createdUserDetails = userDetailsRepository.save(newUserDetails);

        // 저장된 사용자 정보를 DTO로 변환하여 반환
        return convertToDTO(createdUserDetails);
    }

    // UserDetails를 UserDetailsRequestDto로 변환
    private UserDetailsRequestDto convertToDTO(UserDetails userDetails) {
        UserDetailsRequestDto userDetailsRequestDto = new UserDetailsRequestDto();
        userDetailsRequestDto.setMbti(userDetails.getUserMbti());
        userDetailsRequestDto.setIntro(userDetails.getUserIntro());
        userDetailsRequestDto.setStyle(userDetails.getUserStyle());
        return userDetailsRequestDto;
    }

    // 사용자 상세 정보 업데이트를 위한 메서드 추가
    public void updateUserDetails(String userId, String userIntro, String userStyle, String userMbti) {
        UserDetails userDetails = userDetailsRepository.findByUsers_UserId(userId);
        if (userDetails != null) {
            userDetails.setUserIntro(userIntro);
            userDetails.setUserStyle(userStyle);
            userDetails.setUserMbti(userMbti);
            userDetailsRepository.save(userDetails);
        }
    }
}