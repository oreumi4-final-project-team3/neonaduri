package com.est.neonaduri.domain.companions.service;

import com.est.neonaduri.domain.companions.repository.CompanionsRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanionsService {

    private final CompanionsRepository companionsRepository;

    public CompanionsService(CompanionsRepository companionsRepository) {
        this.companionsRepository = companionsRepository;
    }
}
