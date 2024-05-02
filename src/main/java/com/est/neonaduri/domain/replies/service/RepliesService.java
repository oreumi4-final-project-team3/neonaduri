package com.est.neonaduri.domain.replies.service;

import com.est.neonaduri.domain.replies.repository.RepliesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepliesService {
    private final RepliesRepository repliesRepository;
}
