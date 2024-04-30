package com.est.neonaduri.spots.config;

public class ApiConst {
    /**
     * Tour API 호출 시 필요한 정보
     * 추후 ENUM 처리도 고려
     *
     * @author lsh
     */
    public static final String TOUR_API_ENDPOINT = "https://apis.data.go.kr/B551011/KorService1";
    public static final String DEFAULT_QUERY_PARAMS="&MobileOS=ETC&MobileApp=neonaduri&_type=json";
    public static final String LOCATION_INFO_BASED="/locationBasedList1";
    public static final String COMMON_INFO_BASED="/detailCommon1";
}
