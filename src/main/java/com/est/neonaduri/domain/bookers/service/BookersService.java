package com.est.neonaduri.domain.bookers.service;

import com.est.neonaduri.domain.bookers.domain.Bookers;
import com.est.neonaduri.domain.bookers.repository.BookersRepository;
import com.est.neonaduri.domain.companions.repository.CompanionsRepository;
import com.est.neonaduri.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookersService {
    private final BookersRepository bookersRepository;
    private final UserRepository userRepository;
    private final CompanionsRepository companionsRepository;

    public Bookers save(String userId, String comId){
        return bookersRepository.save(Bookers.builder()
                        .users(userRepository.findByUserId(userId))
                        .companions(companionsRepository.findByCompanionId(comId))
                        .build());
    }

}
