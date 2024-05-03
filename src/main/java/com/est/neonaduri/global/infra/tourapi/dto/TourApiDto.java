package com.est.neonaduri.global.infra.tourapi.dto;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import com.est.neonaduri.global.infra.tourapi.config.ContentCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class TourApiDto {


    /**
     * 오픈 API 서버에서 가져온 데이터를 우선적으로 받는 DTO
     */
    private String contentId;
    private String title;
    private String address;
    private String overview;
    private int areaCode;
    private Long contentTypeId;
    private String firstImage;
    private double mapX;
    private double mapY;

    public Posts toPostsEntity(Users user){
        return Posts.builder()
                .postCategory("spots")
                .postTitle(title)
                .spotName(title)
                .postContent(overview)
                .address(address)
                .areaCode(areaCode)
                .users(user) // ROLE_ADMIN 계정 필요
                .build();
    }

    public Spots toSpotsEntity(Posts posts) {
        return Spots.builder()
                .spotId(contentId)
                .posts(posts)
                .spotType(contentTypeId)
                .mapX(mapX)
                .mapY(mapY)
                .spotImg(firstImage)
                .build();
    }
}