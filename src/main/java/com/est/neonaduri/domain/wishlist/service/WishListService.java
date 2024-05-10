package com.est.neonaduri.domain.wishlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.dto.CompanionsDTO;
import com.est.neonaduri.domain.companions.repository.CompanionsRepository;
import com.est.neonaduri.domain.posts.domain.Posts;
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


    public Page<CompanionsDTO> getWishlists(String userId, Pageable pageable) {
        Page<Wishlist> wishlists = wishListRepository.findAllByUsersUserId(userId,pageable);
        List<CompanionsDTO> dtoList = new ArrayList<>();

        for (Wishlist wishlist : wishlists) {
            String postId = wishlist.getPosts().getPostId();
            Optional<Companions> companions = companionsRepository.findByPosts_PostId(postId);

            if (companions != null) {
                CompanionsDTO dto = new CompanionsDTO(
                    companions.get().getPosts().getUsers().getUserName(),
                    companions.get().getPosts().getUsers().getUserBirth(),
                    companions.get().getPosts().getUsers().getUserGender(),
                    companions.get().getComStart(),
                    companions.get().getComEnd(),
                    companions.get().getPosts().getPostTitle(),
                    companions.get().getPosts().getPostContent()
                );
                dtoList.add(dto);
            }

        }
        return new PageImpl<>(dtoList, pageable, wishlists.getTotalElements());
    }
}
