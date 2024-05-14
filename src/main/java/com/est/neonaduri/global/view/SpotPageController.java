package com.est.neonaduri.global.view;

import com.est.neonaduri.domain.spots.dto.SpotPageDto;
import com.est.neonaduri.domain.spots.service.SpotsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SpotPageController {
    private final SpotsService spotsService;

    @GetMapping("/spots")
    public String getAllSpots(Model model,
                              @RequestParam(defaultValue = "1")int page,
                              @RequestParam(defaultValue = "12")int size){
        Pageable pageable = PageRequest.of( Math.max(page-1, 0),size);
        model.addAttribute("spots",spotsService.getAllSpots(pageable));
        model.addAttribute("currentPage",page);
        model.addAttribute("pageType","all");
        return "here";
    }

    @GetMapping("/spots/id/{postId}")
    public String showSpot(@PathVariable String postId, Model model){
        SpotPageDto spotPage = spotsService.getSpotPageByPostId(postId);
        model.addAttribute("spotPage",spotPage);

        return "post-spot-page";
    }

    @GetMapping("spots/{areaCode}")
    public String getSameAreaSpot(@PathVariable int areaCode
            ,Model model
            ,@RequestParam(defaultValue = "1")int page
            ,@RequestParam(defaultValue = "12")int size){

        Pageable pageable = PageRequest.of( Math.max(page-1, 0),size);
        model.addAttribute("spots",spotsService.getSameAreaSpots(areaCode,pageable));
        model.addAttribute("currentPage",page);
        model.addAttribute("pageType","region");
        return "here";
    }

}
