package com.est.neonaduri.spots.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LocationResponse {

    private String contentId;
    private String title;
    private String address;
    private String areaName;
    private String contentName;
    private String firstImage;
    private double mapX;
    private double mapY;
}