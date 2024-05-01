package com.est.neonaduri.spots.controller;

import com.est.neonaduri.spots.dto.TourApiDto;
import com.est.neonaduri.spots.service.ApiManager;
import com.est.neonaduri.spots.service.SpotsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/tourApi")
@RequiredArgsConstructor
@Slf4j
public class ApiController {
    private final ApiManager apiManager;
    private final SpotsService spotsService;

    @GetMapping("/locationInfo/{mapX}/{mapY}")
    public ResponseEntity<List<TourApiDto>> findByLocationInfo(@PathVariable double mapX,@PathVariable double mapY){
        log.info("메서드 호출");
        List<TourApiDto> spots = apiManager.fetchByLocationInfo(mapX, mapY, 20000, 10);
        return ResponseEntity.ok(spots);
    }


    @GetMapping("/areaBasedList")
    public ResponseEntity<List<String>> findByLocationInfo(){
        List<String> contentIdList = apiManager.fetchByAreaBased(10, 1, 12);
        return ResponseEntity.ok(contentIdList);
    }

    @GetMapping("/saveSpots")
        public ResponseEntity<Void> saveSpots(){
            spotsService.saveSpots();
            return ResponseEntity.ok().build();
    }


}
