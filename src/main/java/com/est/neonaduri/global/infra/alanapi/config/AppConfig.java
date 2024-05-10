package com.est.neonaduri.global.infra.alanapi.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                .registerModule(new JavaTimeModule());
    }
}
