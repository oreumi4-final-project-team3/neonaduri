package com.est.neonaduri.domain.bookers.service;

import com.est.neonaduri.domain.bookers.domain.Bookers;
import com.est.neonaduri.domain.bookers.repository.BookersRepository;
import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.repository.CompanionsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookersService {
    private final BookersRepository bookersRepository;
    private final UserRepository userRepository;
    private final CompanionsRepository companionsRepository;

    public Bookers save(String userId, String comId){
        Users user = userRepository.findByUserId(userId);
        Companions companion = companionsRepository.findByCompanionId(comId);

        return bookersRepository.save(Bookers.builder()
                        .users(user)
                        .companions(companion)
                        .build());
    }

    public List<Bookers> getBookersByUserId(String userId){
        Users user = userRepository.findByUserId(userId);
        return bookersRepository.findAllByUsers(user);
    }
}
