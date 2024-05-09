package com.est.neonaduri.global.infra.alanapi.service;

import com.est.neonaduri.global.infra.alanapi.dto.AlanApiSseDto;
import com.est.neonaduri.global.infra.alanapi.config.ApiConst;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import com.fasterxml.jackson.core.JsonParser;


@Component
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:config.properties")
public class AlanService {

    @Value("${Alan-Api-ClientKey2}")
    private String clientId;

    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    public Flux<AlanApiSseDto> performAlan(String searchKeyword) {
        String alanSseUrl = createAlanSseUrl(searchKeyword);
        return apiResponse(alanSseUrl);
    }

    public Flux<AlanApiSseDto> apiResponse(String alanSseUrl){
        return webClient.get()
                .uri(alanSseUrl)
                .retrieve()
                .bodyToFlux(String.class)
                .flatMap(this::parseResponse);
    }

    public Flux<AlanApiSseDto> parseResponse(String jsonString) {
        try {
            AlanApiSseDto alanApiSseDto = objectMapper.readValue(jsonString, AlanApiSseDto.class);
            return Flux.just(alanApiSseDto);
        } catch (Exception e) {
            return Flux.error(e);
        }
    }


    private String createAlanSseUrl(String searchKeyword){
        return ApiConst.ALAN_API_ENDPOINT+setContent(searchKeyword)+setClientKey(clientId);
    }
    private String setContent(String content){
        return "?content="+content;
    }
    private String setClientKey(String clientId){
        return "&client_id="+clientId;
    }
}
