package com.est.neonaduri.domain.replies.service;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.replies.domain.Replies;
import com.est.neonaduri.domain.replies.dto.ReplyRequestDto;
import com.est.neonaduri.domain.replies.repository.RepliesRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RepliesService {
    private final RepliesRepository repliesRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    @Transactional
    public Replies saveReply(String postId, String userId, ReplyRequestDto dto){
        Posts findPost = postsRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시물이 없습니다"));
        Users findUser = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("해당하는 유저 정보가 없습니다."));
        Replies reply = dto.toEntity(findPost, findUser);
        return repliesRepository.save(reply);
    }
}
