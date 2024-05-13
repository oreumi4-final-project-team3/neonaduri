package com.est.neonaduri.global.view;

import com.est.neonaduri.domain.companions.service.CompanionsService;
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
public class CompanionPageController {
    private final CompanionsService companionsService;

    @GetMapping("/uploadCompanion")
    public String uploadCompanion() {
        return "uploadCompanion";
    }

    @GetMapping("/companions")
    public String getAllCompanions(Model model,
                                   @RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);

        model.addAttribute("companions", companionsService.getAllCompanions(pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "region");
        return "companions";
    }

    @GetMapping("/companions/{areaCode}")
    public String getCompanionsByAreaCode(@PathVariable int areaCode, Model model,
                                          @RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);

        model.addAttribute("companions", companionsService.getCompanionsByAreaCode(areaCode, pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "region");

        return "companions";
    }

}
