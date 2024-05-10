package com.est.neonaduri.domain.wishlist.controller;

import com.est.neonaduri.domain.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class WishListController {
    private final WishListService wishListService;

    @GetMapping("/api/wishlist/{admin_id}")
    public String getWishlist(@PathVariable("admin_id") String adminId, Model model
        ,@RequestParam(defaultValue = "1")int page
        ,@RequestParam(defaultValue = "4")int size){

        Pageable pageable = PageRequest.of( Math.max(page-1, 0),size);
        model.addAttribute("companions",wishListService.getWishlists(adminId,pageable));
        model.addAttribute("currentPage",page);
        return "wishlist";
    }
}
