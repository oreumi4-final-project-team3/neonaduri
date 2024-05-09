package com.est.neonaduri.global.infra.alanapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AlanApiSseDto {
    @JsonProperty("data")
    private Data data;


    @JsonProperty("type")
    private String type;

    @Getter
    public static class Data{
        @JsonProperty(value = "content")
        private String content;

        @JsonProperty(value = "name")
        private String name;

        @JsonProperty(value = "speak")
        private String speak;
    }

}
