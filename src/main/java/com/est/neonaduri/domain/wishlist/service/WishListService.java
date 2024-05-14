package com.est.neonaduri.domain.wishlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.dto.CompanionsDTO;
import com.est.neonaduri.domain.companions.repository.CompanionsRepository;
import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.repository.PostImagesRepository;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import com.est.neonaduri.domain.wishlist.domain.Wishlist;
import com.est.neonaduri.domain.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wishListRepository;
    private final CompanionsRepository companionsRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;
    private final PostImagesRepository postImagesRepository;


    public Page<CompanionsDTO> getWishlists(String userId, Pageable pageable) {
        Page<Wishlist> wishlists = wishListRepository.findAllByUsersUserId(userId, pageable);
        List<CompanionsDTO> dtoList = new ArrayList<>();

        for (Wishlist wishlist : wishlists) {
            String postId = wishlist.getPosts().getPostId();
            Companions companions = companionsRepository.findByPosts_PostId(postId).orElseThrow();

            if (companions != null) {
                CompanionsDTO dto = new CompanionsDTO(
                        companions.getPosts().getUsers().getUserName(),
                        companions.getPosts().getUsers().getUserBirth(),
                        companions.getPosts().getUsers().getUserGender(),
                        companions.getComStart(),
                        companions.getComEnd(),
                        companions.getPosts().getPostTitle(),
                        companions.getPosts().getPostContent(),
                        findImgLink(companions),
                        companions.getCompanionId()
                );
                dtoList.add(dto);
            }

        }
        return new PageImpl<>(dtoList, pageable, wishlists.getTotalElements());
    }
    String findImgLink(Companions companion){
        PostImages postImage = postImagesRepository.findPostImagesByPosts(companion.getPosts());
        if(postImage != null){
            return postImage.getPostImagesId();
        }
        return "/images/companionTestImg.png";
    }

    //CJW
    public Wishlist save(String userId, String postId) {
        Users user = userRepository.findByUserId(userId);
        Posts post = postsRepository.findByPostId(postId);

        return wishListRepository.save(Wishlist.builder()
                .users(user)
                .posts(post)
                .build());
    }
}
