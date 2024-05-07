package com.est.neonaduri.domain.spots.dto;

import lombok.Data;

@Data
public class SpotPageDto {
    private String spotName;
    private String spotAddr;
    private String spotImg;
    private String spotOverview;
    private Integer areaCode;
    private double mapX;
    private double mapY;

    public SpotPageDto(String spotName, String spotAddr, String spotImg, String spotOverview, Integer areaCode, double mapX, double mapY) {
        this.spotName = spotName;
        this.spotAddr = spotAddr;
        this.spotImg = spotImg;
        this.spotOverview = spotOverview;
        this.areaCode = areaCode;
        this.mapX = mapX;
        this.mapY = mapY;
    }
}
