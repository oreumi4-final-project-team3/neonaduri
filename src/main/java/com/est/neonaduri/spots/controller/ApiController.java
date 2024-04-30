package com.est.neonaduri.spots.controller;

import com.est.neonaduri.spots.service.ApiManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.UnsupportedEncodingException;




@RestController
@RequiredArgsConstructor
public class ApiController {
    private final ApiManager apiManager;

    @GetMapping("tour_Api")
    public ResponseEntity<?> fetch() throws UnsupportedEncodingException {
        return ResponseEntity.ok(apiManager.fetch().getBody());
    }
}
