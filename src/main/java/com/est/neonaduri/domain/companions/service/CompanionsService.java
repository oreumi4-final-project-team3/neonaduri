package com.est.neonaduri.domain.companions.service;

import com.est.neonaduri.domain.bookers.repository.BookersRepository;
import com.est.neonaduri.domain.companions.domain.Companions;

import com.est.neonaduri.domain.companions.dto.CompanionsDTO;

import com.est.neonaduri.domain.companions.dto.CompanionsListDTO;

import com.est.neonaduri.domain.companions.dto.CompanionsResponseDTO;
import com.est.neonaduri.domain.companions.dto.CompanionsWriteDTO;
import com.est.neonaduri.domain.companions.repository.CompanionsRepository;
import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.repository.PostImagesRepository;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.CreatePostDTO;
import com.est.neonaduri.domain.posts.dto.UpdatePostDTO;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import com.est.neonaduri.domain.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanionsService {

    private final CompanionsRepository companionsRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;
    private final PostImagesRepository postImagesRepository;
    private final BookersRepository bookersRepository;
    private final WishListRepository wishListRepository;

    // 동행 CRUD
    // Create
    @Transactional
    public Companions createCompanions(String userId, CreatePostDTO createPostDTO) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID: " + userId));

        Posts savedPost = postsRepository.save(createPostDTO.toPostWriteDTO(user));
        Companions savedCompanions = companionsRepository.save(createPostDTO.toCompanionsWriteDTO(savedPost));

        return savedCompanions;
    }


    // Update
    @Transactional
    public Companions updateCompanions(String userId, String postId, UpdatePostDTO updatePostDTO) {
        Posts post = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + postId));

        if (!userId.equals(post.getUsers().getUserId())) {
            throw new IllegalArgumentException("게시글 작성자와 로그인한 사용자가 일치하지 않습니다!");
        }

        post.setPostCategory(updatePostDTO.getPostCategory());
        post.setPostTitle(updatePostDTO.getPostTitle());
        post.setPostContent(updatePostDTO.getPostContent());
        post.setSpotName(updatePostDTO.getSpotName());
        post.setAreaCode(updatePostDTO.getAreaCode());
        post.setAddress(updatePostDTO.getAddress());
        post.setModified(LocalDateTime.now());
        postsRepository.save(post);

        Companions companions = companionsRepository.findByPosts_PostId(postId)
                .orElseThrow(() -> new IllegalArgumentException("연결된 동행 정보를 찾을 수 없습니다. 게시글 ID: " + postId));

        companions.setComRecruit(updatePostDTO.getComRecruit());
        companions.setComStart(updatePostDTO.getComStart());
        companions.setComEnd(updatePostDTO.getComEnd());
        return companionsRepository.save(companions);
    }

    public List<CompanionsDTO> getHotCompanions(){
        List<Companions> companions = companionsRepository.findHotCompanions();
        List<CompanionsDTO> dtoList = companions.stream()
            .map(companion -> new CompanionsDTO(
                companion.getPosts().getUsers().getUserName(),
                companion.getPosts().getUsers().getUserBirth(),
                companion.getPosts().getUsers().getUserGender(),
                companion.getComStart(),
                companion.getComEnd(),
                companion.getPosts().getPostTitle(),
                companion.getPosts().getPostContent()
            )).collect(Collectors.toList());
        
        return dtoList;
    }

    //CJW
    //companions 저장
    public Companions saveCompanions(CompanionsWriteDTO writeDTO, Posts post){
        return companionsRepository.save(writeDTO.toEntity(post));
    }

    //전체 companions 반환
    public Page<CompanionsResponseDTO> getAllCompanions(Pageable pageable){
        Page<Companions> companions = companionsRepository.findAll(pageable);

        List<CompanionsResponseDTO> dtoList = companions.stream()
                .map(companion -> new CompanionsResponseDTO(companion, companion.getPosts(), companion.getPosts().getUsers(), findImgLink(companion)))
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList,pageable,companions.getTotalElements());
    }

    //지역 코드별 companions 반환
    public Page<CompanionsResponseDTO> getCompanionsByAreaCode(int areaCode, Pageable pageable){
        Page<Companions> companions = companionsRepository.findAllByPosts_AreaCode(areaCode,pageable);

        List<CompanionsResponseDTO> dtoList = companions.stream()
                .map(companion -> new CompanionsResponseDTO(companion, companion.getPosts(), companion.getPosts().getUsers(), findImgLink(companion)))
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList,pageable,companions.getTotalElements());
    }

    String findImgLink(Companions companion){
        PostImages postImage = postImagesRepository.findPostImagesByPosts(companion.getPosts());
        if(postImage != null){
            return postImage.getPostImagesId();
        }
        return "/images/companionTestImg.png";
    }

    public Companions findById(String comId){
        return companionsRepository.findByCompanionId(comId);
    }

    @Transactional
    public Companions afterBook(String comId){
        Companions companion = companionsRepository.findByCompanionId(comId);
        Integer reserved = bookersRepository.countAllByCompanions(companion);

        companion.updateBook(reserved);

        return companion;
    }

    @Transactional
    public Companions afterWish(String comId){
        Companions companion = companionsRepository.findByCompanionId(comId);
        Integer wished = wishListRepository.countAllByPosts(companion.getPosts());

        companion.updateWishList(wished);
        return companion;
    }


}