package com.est.neonaduri.global.infra.alanapi;

import com.est.neonaduri.global.infra.alanapi.dto.AlanApiSseDto;
import com.est.neonaduri.global.infra.alanapi.service.AlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class AlanController {
    private final AlanService alanService;

    @GetMapping(value = "api/alan/{spotName}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<AlanApiSseDto>> getResponse(@PathVariable(name = "spotName")String spotName) {
        return alanService.performAlan(spotName)
                .delayElements(Duration.ofMillis(100))
                .map(dto -> ServerSentEvent.builder(dto).build());
    }
}
