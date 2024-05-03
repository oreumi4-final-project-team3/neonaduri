package com.est.neonaduri.domain.bookers.service;

import com.est.neonaduri.domain.bookers.repository.BookersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookersService {
    private final BookersRepository bookersRepository;
}
