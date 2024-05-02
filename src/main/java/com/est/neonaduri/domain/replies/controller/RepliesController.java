package com.est.neonaduri.domain.replies.controller;

import com.est.neonaduri.domain.replies.service.RepliesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RepliesController {
    private final RepliesService repliesService;
}
