package com.est.neonaduri.global.infra.tourapi.config;

public class ApiConst {
    /**
     * Tour API 호출 시 필요한 정보
     * 추후 ENUM 처리도 고려
     *
     * @author lsh
     */
    public static final String TOUR_API_ENDPOINT = "https://apis.data.go.kr/B551011/KorService1";
    public static final String DEFAULT_QUERY_PARAMS1 ="&MobileOS=ETC&MobileApp=neonaduri&_type=json";
    public static final String DEFAULT_QUERY_PARAMS2 ="?MobileOS=ETC&MobileApp=neonaduri&_type=json";

    public static final String DEFAULT_INFO_PARAMS="&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y";

    public static final String AREA_BASED="/areaBasedList1";
    public static final String COMMON_INFO_BASED="/detailCommon1";
}
