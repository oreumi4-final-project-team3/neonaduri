package com.est.neonaduri.domain.bookers.controller;

import com.est.neonaduri.domain.bookers.domain.Bookers;
import com.est.neonaduri.domain.bookers.service.BookersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookersController {
    private final BookersService bookersService;

    //CREATE
    @PostMapping("/api/bookers/{comId}")
    public ResponseEntity<Bookers> booking(@PathVariable String comId) {
        //security에서 반환 예정
        String userId = "admin_id";

        //작성자 예약 못하는 검증 필요

        Bookers booker = bookersService.save(userId, comId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(booker);
    }
}
