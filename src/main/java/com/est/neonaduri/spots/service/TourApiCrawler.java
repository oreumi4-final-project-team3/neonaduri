package com.est.neonaduri.spots.service;

import com.est.neonaduri.spots.config.AreaCode;
import com.est.neonaduri.spots.config.ContentCode;
import com.est.neonaduri.spots.domain.Spots;
import com.est.neonaduri.spots.dto.TourApiDto;
import com.est.neonaduri.spots.repository.SpotsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TourApiCrawler {
    private final ApiManager apiManager;
    private final SpotsRepository repository;
    public static final int NUMBER_OF_ROWS=5;

    @Scheduled(fixedRate = 60000)
    public void performTourApiCrawler(){
        List<List<String>> contentIds = collectAreaBasedContentId();
        saveSpots(contentIds);
    }

    public List<List<String>> collectAreaBasedContentId(){
        List<List<String>> areaBasedContentIds=new ArrayList<>();
        for(int areaCode: AreaCode.getAllAreaCodes()){
            List<String> areaBasedcontentIdList = apiManager.fetchByAreaBased(NUMBER_OF_ROWS, areaCode, ContentCode.SPOT);
            areaBasedContentIds.add(areaBasedcontentIdList);
        }
        return areaBasedContentIds;
    }
    public void saveSpots(List<List<String>> areaBasedContentIds){
        for(List<String> areaList:areaBasedContentIds){
            for(String contentId:areaList){
                try {
                    if(!existsWithPrefix(contentId)){
                        List<TourApiDto> commonInfoList = apiManager.fetchByCommonInfo(contentId, ContentCode.SPOT);
                        for(TourApiDto dto:commonInfoList){
                            Spots spot = dto.toEntity();
                            repository.save(spot);
                            log.info("최신 데이터 저장 완료={}",spot);
                        }
                    }else{
                        log.info("최신화할 데이터가 없습니다.");
                    }
                }catch (Exception e){
                    log.error("처리중 에러 발생",contentId);
                }
            }
        }
    }

    public boolean existsWithPrefix(String contentId){
        String prefixedContentId="spot_"+contentId;
        return repository.existsById(prefixedContentId);
    }


}
