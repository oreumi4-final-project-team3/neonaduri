package com.est.neonaduri.domain.spots.config;

public class ContentCode {
    public static final int SPOT = 12;

    //확장성 고려 지역 별 컨텐츠 기반 정리
    public static final int 문화시설 = 14;
    public static final int 행사_공연_축제 = 15;
    public static final int 여행코스 = 25;
    public static final int 레포츠 = 28;
    public static final int 숙박 = 32;
    public static final int 쇼핑 = 38;
    public static final int 음식점 = 39;

    public static String getContentName(Long contentCode) {
        if (contentCode == ContentCode.SPOT) return "관광지";
        else return "기타";
    }
}