package com.est.neonaduri.domain.userDetails.controller;

import com.est.neonaduri.domain.userDetails.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserDetailsController {
    private final UserDetailsService userDetailsService;
}
