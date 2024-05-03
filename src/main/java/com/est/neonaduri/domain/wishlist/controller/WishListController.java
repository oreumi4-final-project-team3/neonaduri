package com.est.neonaduri.domain.wishlist.controller;

import com.est.neonaduri.domain.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WishListController {
    private final WishListService wishListService;
}
