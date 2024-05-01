package com.est.neonaduri.companions.controller;

import com.est.neonaduri.companions.service.CompanionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanionsController {
    private final CompanionsService companionsService;
}
