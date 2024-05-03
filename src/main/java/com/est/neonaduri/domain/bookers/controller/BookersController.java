package com.est.neonaduri.domain.bookers.controller;

import com.est.neonaduri.domain.bookers.service.BookersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookersController {
    private final BookersService bookersService;
}
