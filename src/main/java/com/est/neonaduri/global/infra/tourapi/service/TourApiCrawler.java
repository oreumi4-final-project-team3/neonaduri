package com.est.neonaduri.global.infra.tourapi.service;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import com.est.neonaduri.domain.spots.domain.Spots;
import com.est.neonaduri.domain.spots.repository.SpotsRepository;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.domain.users.repository.UserRepository;
import com.est.neonaduri.global.infra.tourapi.config.AreaCode;
import com.est.neonaduri.global.infra.tourapi.config.ContentCode;
import com.est.neonaduri.global.infra.tourapi.dto.TourApiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TourApiCrawler {
    private final ApiManager apiManager;
    private final SpotsRepository spotsRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    public static final int NUMBER_OF_ROWS=5;

    // 매달 1일 10시30분에 실행
    @Scheduled(cron = "0 30 10 1 * *")
    //60초마다 갱신

    //@Scheduled(fixedRate = 60000)

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
    @Transactional
    public void saveSpots(List<List<String>> areaBasedContentIds){
        for(List<String> areaList:areaBasedContentIds){
            for(String contentId:areaList){
                try {
                    if(!existsWithPrefixSpotId(contentId)){
                        List<TourApiDto> commonInfoList = apiManager.fetchByCommonInfo(contentId, ContentCode.SPOT);
                        for(TourApiDto dto:commonInfoList){
                            Posts postsEntity = dto.toPostsEntity(findAdminUser());
                            Spots spotsEntity = dto.toSpotsEntity(postsEntity);
                            postsRepository.save(postsEntity);
                            spotsRepository.save(spotsEntity);
                            log.info("최신 데이터 저장 완료={}",postsEntity,spotsEntity);
                        }
                    }else{
                        log.info("최신화할 데이터가 없습니다.");
                    }
                }catch (Exception e){
                    log.error("처리중 에러 발생"+e.getMessage());
                }
            }
        }
    }

    public boolean existsWithPrefixSpotId(String contentId){
        String prefixedContentId="spot_"+contentId;
        return spotsRepository.existsById(prefixedContentId);
    }

    public Users findAdminUser(){
        return userRepository.findByUserId("admin_id");
    }

}
