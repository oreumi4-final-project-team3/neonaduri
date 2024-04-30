package com.est.neonaduri.spots.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Component
public class ApiManager {
    private final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1";
    private final String apiUri = "/areaBasedList1";
    private final String numOfRows = "?numOfRows=10";
    private final String defaultQueryParam = "&MobileOS=ETC&MobileApp=neonaduri&_type=json";
    private final String contentTypeId = "&contentTypeId=12";
    private final String areaCode = "&areaCode=1";
    private final String serviceKey = "&ServiceKey=7NrQ3WH4ERZYHM+tUcFo2STWv+z2RrQ4dODd9xj/biwY/nVAVGRrhI+5j3ROgSltI3qRY8rC3ofAnZ570BcK8A==";



    private String makeUrl() throws UnsupportedEncodingException {
        return BASE_URL +
                apiUri +
                numOfRows +
                defaultQueryParam +
                contentTypeId+
                areaCode +
                serviceKey
                ;

    }

    public ResponseEntity<?> fetch() throws UnsupportedEncodingException {
        System.out.println(makeUrl());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl(), HttpMethod.GET, entity, Map.class);
        System.out.println(resultMap.getBody());
        return resultMap;
    }
}