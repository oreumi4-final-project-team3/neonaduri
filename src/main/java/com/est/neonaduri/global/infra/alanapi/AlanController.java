package com.est.neonaduri.global.infra.alanapi;

import com.est.neonaduri.global.infra.alanapi.dto.AlanApiSseDto;
import com.est.neonaduri.global.infra.alanapi.service.AlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

@Controller //restcontroller로 변경 고려.
@RequiredArgsConstructor
public class AlanController {
    private final AlanService alanService;

    @GetMapping(value = "api/alan", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<AlanApiSseDto>> getResponse() {
        return alanService.performAlan("경복궁")
                .map(dto -> ServerSentEvent.builder(dto).build());
    }
}
