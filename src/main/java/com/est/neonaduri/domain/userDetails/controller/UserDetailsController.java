package com.est.neonaduri.domain.userDetails.controller;

import com.est.neonaduri.domain.userDetails.domain.UserDetails;
import com.est.neonaduri.domain.userDetails.dto.UserDetailsRequestDto;
import com.est.neonaduri.domain.userDetails.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserDetailsController {
    private final UserDetailsService userDetailsService;

    /**
     * UsersDetails 저장하는 API
     *
     * @return UserDetails : 저장된 userDetials
     * @author cjw
     */
    @PostMapping("/api/userdetails/{userId}")
    public ResponseEntity<UserDetails> addUserDetails(@PathVariable(name="userId") String userId,
                                               @RequestPart(value = "userDetailsRequest") UserDetailsRequestDto request ){
        UserDetails newUserDetails = userDetailsService.saveUserDetails(userId,request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newUserDetails);
    }

    /**
     * UsersDetails 를 찾아주는 API
     *
     * @return UserDetails : userId와 맞는 userDetails
     * @author cjw
     */
    @GetMapping("/api/userdetails/{userId}")
    public ResponseEntity<UserDetails> getUserDetails(@PathVariable(name="userId") String userId){
        UserDetails findUserDetails = userDetailsService.findUserDetails(userId);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(findUserDetails);
    }

    /**
     * UsersDetails 를 수정해주는 API
     *
     * @return UserDetails : 수정된 userDetails
     * @author cjw
     */
    @PutMapping("api/userdetails/{userId}")
    public ResponseEntity<UserDetails> updateUserDetails(@PathVariable(name="userId") String userId,
                                                         @RequestPart(value = "userDetailsRequest")UserDetailsRequestDto request){
        UserDetails updatedUserDetails = userDetailsService.updateUserDetails(userId,request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(updatedUserDetails);
    }
}