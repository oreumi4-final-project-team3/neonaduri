package com.est.neonaduri.companions.service;

import com.est.neonaduri.companions.repository.CompanionsRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanionsService {

    private final CompanionsRepository companionsRepository;

    public CompanionsService(CompanionsRepository companionsRepository) {
        this.companionsRepository = companionsRepository;
    }
}
