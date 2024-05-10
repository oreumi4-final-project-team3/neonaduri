package com.est.neonaduri.domain.wishlist.controller;

import com.est.neonaduri.domain.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class WishListController {
    private final WishListService wishListService;

    @GetMapping("/api/wishlist/{userId}")
    public String getWishlist(@PathVariable String userId, Model model){
        model.addAttribute("companions",wishListService.getWishlists(userId));
        return "wishlist";
    }
}
