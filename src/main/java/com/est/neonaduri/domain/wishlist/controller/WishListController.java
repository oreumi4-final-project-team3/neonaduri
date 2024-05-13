package com.est.neonaduri.domain.wishlist.controller;

import com.est.neonaduri.domain.wishlist.domain.Wishlist;
import com.est.neonaduri.domain.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/wishlist/{postId}")
    public ResponseEntity<Wishlist> wishing(@PathVariable String postId){
        //security에서 받을 예정
        String userId = "admin_id";

        Wishlist wishlist = wishListService.save(userId,postId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(wishlist);
    }
}
