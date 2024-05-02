package com.est.neonaduri.domain.spots.dto;

import com.est.neonaduri.domain.spots.domain.Spots;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
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

    public Spots toEntity() {
        return Spots.builder()
                .spotId(contentId)
                .spotName(title)
                .spotAddr(address)
                .spotOverview(overview)
                .mapX(mapX)
                .mapY(mapY)
                .spotImg(firstImage)
                .spotType(contentTypeId)
                .areaCode(areaCode)
                .build();
    }
}