package com.est.neonaduri.spots.config;

public class AreaCode {
    public static final int SEOUL = 1;
    public static final int GYEONGGI = 31;
    public static final int INCHEON= 2;
    public static final int GANGWON = 32;
    public static final int CHUNGBUK = 33;
    public static final int CHUNGNAM = 34;
    public static final int GYEOUNGBUK = 35;
    public static final int GYEONGNAM = 36;
    public static final int JEONBUK = 37;
    public static final int JEONNAM = 38;
    public static final int JEJU = 39;

    public static String getAreaName(Long areaCode) {
        if (areaCode == AreaCode.SEOUL) return "서울";
        else if(areaCode== AreaCode.INCHEON) return "인천";
        else if (areaCode == AreaCode.GYEONGGI) return "경기도";
        else if (areaCode == AreaCode.GANGWON) return "강원도";
        else if (areaCode == AreaCode.CHUNGBUK) return "충청북도";
        else if (areaCode == AreaCode.CHUNGNAM) return "충청남도";
        else if (areaCode == AreaCode.GYEOUNGBUK) return "경상북도";
        else if (areaCode == AreaCode.GYEONGNAM) return "경상남도";
        else if (areaCode == AreaCode.JEONBUK) return "전라북도";
        else if (areaCode == AreaCode.JEONNAM) return "전라남도";
        else if (areaCode == AreaCode.JEJU) return "제주도";
        else return "기타";
    }
}
