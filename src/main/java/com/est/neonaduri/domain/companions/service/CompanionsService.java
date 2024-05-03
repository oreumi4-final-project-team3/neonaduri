package com.est.neonaduri.domain.companions.service;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.repository.CompanionsRepository;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.CreatePostDTO;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanionsService {

    private final CompanionsRepository companionsRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;

    @Autowired
    public CompanionsService(CompanionsRepository companionsRepository, UserRepository userRepository, PostsRepository postsRepository) {
        this.companionsRepository = companionsRepository;
        this.userRepository = userRepository;
        this.postsRepository = postsRepository;
    }

    // 동행 CRUD
    // Create
    @Transactional
    public Companions createCompanions(String userId, CreatePostDTO createPostDTO) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID: " + userId));
        // 게시글 생성
        Posts savedPost = postsRepository.save(createPostDTO.toPostWriteDTO(user));
        Companions savedCompanions = companionsRepository.save(createPostDTO.toCompanionsWriteDTO(savedPost));

        return savedCompanions;


//        Posts posts = postsRepository.findById(postId)
//                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다. ID: " + postId));
//        Posts savedPost = postsRepository.save(postWriteDTO.toEntity(user));
//        Companions companions = companionsWriteDTO.toEntity(posts);
//        companions.setPosts(savedPost);
//        return companionsRepository.save(companions);
    }
}