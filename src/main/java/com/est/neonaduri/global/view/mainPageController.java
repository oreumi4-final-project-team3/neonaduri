package com.est.neonaduri.global.view;

import com.est.neonaduri.domain.companions.service.CompanionsService;
import com.est.neonaduri.domain.posts.service.SearchService;
import com.est.neonaduri.domain.spots.service.SpotsService;
import com.est.neonaduri.global.config.auth.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class mainPageController {
    private final SpotsService spotsService;
    private final CompanionsService companionsService;
    private final SearchService searchService;
    private final HttpSession httpSession;

    @GetMapping("/neonaduri")
    public String getMainPage(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            System.out.println("user is Loged In!!!!");
            model.addAttribute("userName",user.getName());
        }
        model.addAttribute("spots",spotsService.getHotSpots());
        model.addAttribute("companions",companionsService.getHotCompanions());
        model.addAttribute("top",spotsService.getToptenSpots());
        model.addAttribute("searchRank",searchService.getSearchRankList());
        return "main";
    }

}
