package com.est.neonaduri.spots.service;

import com.est.neonaduri.spots.config.ApiConst;
import com.est.neonaduri.spots.dto.TourApiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
@Slf4j
@PropertySource("classpath:config.properties") // tourApi 서비스 키 관리
public class ApiManager {
    /**
     * Tour api 서버에서 데이터 추출 및 직렬화 역할 수행.
     */


    @Value("${Tour-API-ServiceKey3}")
    private String serviceKey;



    /**
     * 조회 메서드
     */

    // 위치 기반 조회 -> 추후 필요 시 사용
    public List<TourApiDto> fetchByLocationInfo(double mapX,double mapY,int radius,int numOfRows){
        log.info("fetch메서드 정상 호출");
        String locationInfoUrl=createLocationInfoUrl(mapX,mapY,radius,numOfRows);
        log.info("url확인={}",locationInfoUrl);
        return fetch(locationInfoUrl);
    }

    // 지역코드 기반 관광지 조회 -> contentId 추출용
    public List<String> fetchByAreaBased(int numOfRows,int areaCode,int contentTypeCode){
        String areaBasedUrl = createAreaBasedUrl(numOfRows, areaCode, contentTypeCode);
        List<TourApiDto> fetchedList = fetch(areaBasedUrl);

        return fetchedList.stream()
                .map(TourApiDto::getContentId)
                .collect(Collectors.toList());
    }


    //공통 정보 조회 -> contentId로 단건 조회만 가능
    public List<TourApiDto> fetchByCommonInfo(String contentId,int contentTypeId){
        String commonInfoUrl = createCommonInfoUrl(contentId, contentTypeId);
        return fetch2(commonInfoUrl);
    }





    // contentId에 해당하는 이미지 조회

    /**
     * URL 생성기
     */
    private String createBasedUrl(String apiUrlType){
        return ApiConst.TOUR_API_ENDPOINT+apiUrlType;
    }
    private String createLocationInfoUrl(double mapX,double mapY,int radius,int numOfRows){
        return createBasedUrl(ApiConst.LOCATION_INFO_BASED)+setNumOfRows(numOfRows)+ApiConst.DEFAULT_QUERY_PARAMS1 +setPosition(mapX,mapY,radius)+setServiceKey(serviceKey);
    }
    private String createAreaBasedUrl(int numOfRows, int areaCode,int contentTypeCode){
        return createBasedUrl(ApiConst.AREA_BASED)+setNumOfRows(numOfRows)+ApiConst.DEFAULT_QUERY_PARAMS1 +setContentTypeId(contentTypeCode)+setAreaCode(areaCode)+setServiceKey(serviceKey);
    }
    private String createCommonInfoUrl(String contentId,int contentTypeId){
        return createBasedUrl(ApiConst.COMMON_INFO_BASED)+ApiConst.DEFAULT_QUERY_PARAMS2 +setContentId(contentId)+setContentTypeId(contentTypeId)+ApiConst.DEFAULT_INFO_PARAMS+setServiceKey(serviceKey);
    }


    /**
     * 요청 쿼리 처리
     */
    // 서비스 키 관리
    private String setServiceKey(String serviceKey){
        String encoded = URLEncoder.encode(serviceKey, StandardCharsets.UTF_8);
        return "&serviceKey="+encoded;
    }
    // 지역 코드 입력
    private String setAreaCode(int code) {
        return "&areaCode=" + code;
    }

    // 가져올 데이터 수 정하기
    private String setNumOfRows(int n) {
        if (n < 0 || n > 10000) {
            // 범위를 넘어가면 디폴트값 내리기
            return "?numOfRows=10";
        }
        return "?numOfRows=" + n;
    }
    // 컨텐츠 아이디
    private String setContentId(String contentId){
        return "&contentId="+contentId;
    }

    // 컨텐츠 타입 지정하기
    private String setContentTypeId(int code) {
        return "&contentTypeId=" + code;
    }

    // 위치 정보 입력
    private String setPosition(double mapX, double mapY, int radius) {
        return "&mapX=" + mapX + "&mapY=" + mapY + "&radius=" + radius;
    }



    /**
     * Tour Api 서버에서 데이터 받아오는 메서드
     * @author lsh
     */
    public List<TourApiDto> fetch(String url){
        log.info("fetch메서드 시작");
        List<TourApiDto> result=new ArrayList<>();
        try {
            log.info("try문 접근={}",url);
            RestTemplate restTemplate = new RestTemplate();
            URI uri=new URI(url);
            String jsonString=restTemplate.getForObject(uri,String.class);
            log.info("jsonString={}",jsonString);
            JSONParser jsonParser=new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);

            // 가장 상단부인 response부분 파싱
            JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
            log.info("complete parsing1={}",jsonResponse);
            // 그 다음  body 파싱
            JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
            log.info("complete parsing2={}",jsonBody);
            // 그 다음 위치 정보 배열 items 파싱
            JSONObject jsonItems = (JSONObject) jsonBody.get("items");
            log.info("complete parsing3={}",jsonItems);
            // 최종적으로 개별 위치 정보를 배열로  ->직렬화 필요
            JSONArray jsonItemList = (JSONArray) jsonItems.get("item");
            log.info("complete parsing4={}",jsonItemList);

            for(Object o :jsonItemList){
                JSONObject item = (JSONObject) o;
                TourApiDto tourApiDto = makeLocationDto1(item);
                if(tourApiDto==null) continue;
                result.add(tourApiDto);
            }
            log.info("직렬화 완료={}",result);
            return result;
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            return result;
        }
    }
    public List<TourApiDto> fetch2(String url){
        log.info("fetch메서드 시작");
        List<TourApiDto> result=new ArrayList<>();
        try {
            log.info("try문 접근={}",url);
            RestTemplate restTemplate = new RestTemplate();
            URI uri=new URI(url);
            String jsonString=restTemplate.getForObject(uri,String.class);
            log.info("jsonString={}",jsonString);
            JSONParser jsonParser=new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);

            // 가장 상단부인 response부분 파싱
            JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
            log.info("complete parsing1={}",jsonResponse);
            // 그 다음  body 파싱
            JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
            log.info("complete parsing2={}",jsonBody);
            // 그 다음 위치 정보 배열 items 파싱
            JSONObject jsonItems = (JSONObject) jsonBody.get("items");
            log.info("complete parsing3={}",jsonItems);
            // 최종적으로 개별 위치 정보를 배열로  ->직렬화 필요
            JSONArray jsonItemList = (JSONArray) jsonItems.get("item");
            log.info("complete parsing4={}",jsonItemList);

            for(Object o :jsonItemList){
                JSONObject item = (JSONObject) o;
                TourApiDto tourApiDto = makeLocationDto2(item);
                if(tourApiDto==null) continue;
                result.add(tourApiDto);
            }
            log.info("직렬화 완료={}",result);
            return result;
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            return result;
        }
    }

    /**
     * 콘텐츠 정보 직렬화 (JSON -> DTO)
     * @author lsh
     */
    private TourApiDto makeLocationDto1(JSONObject item) {

        return TourApiDto.builder()
                .contentId((String) item.get("contentid"))
                .title((String) item.get("title"))
                .address((String) item.get("addr1"))
                .areaCode((int) Long.parseLong((String) item.get("areacode"))) // 문자열을 Long으로 변환
                .contentTypeId(Long.parseLong((String) item.get("contenttypeid"))) // 문자열을 Long으로 변환
                .firstImage((String) item.get("firstimage"))
                .mapX(Double.parseDouble((String) item.get("mapx"))) // 문자열을 double로 변환
                .mapY(Double.parseDouble((String) item.get("mapy"))) // 문자열을 double로 변환
                .build();
    }
    private TourApiDto makeLocationDto2(JSONObject item) {

        return TourApiDto.builder()
                .contentId((String) item.get("contentid"))
                .title((String) item.get("title"))
                .address((String) item.get("addr1"))
                .areaCode((int) Long.parseLong((String) item.get("areacode"))) // 문자열을 Long으로 변환
                .contentTypeId(Long.parseLong((String) item.get("contenttypeid"))) // 문자열을 Long으로 변환
                .firstImage((String) item.get("firstimage"))
                .mapX(Double.parseDouble((String) item.get("mapx"))) // 문자열을 double로 변환
                .mapY(Double.parseDouble((String) item.get("mapy"))) // 문자열을 double로 변환
                .overview((String) item.get("overview"))
                .build();
    }
}