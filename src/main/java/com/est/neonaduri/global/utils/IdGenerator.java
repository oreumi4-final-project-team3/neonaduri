package com.est.neonaduri.global.utils;

import java.util.UUID;

public class IdGenerator {
    public static String generateUserId(){
        return "user_"+ UUID.randomUUID().toString();
    }

    public static String generateSpotId(String spotId) {
        return "spot_"+ spotId;
    }
    // 동행, 리뷰에 따라 달라지게
    public static String generatePostId(String category){
        return "post_"+category+"_"+UUID.randomUUID().toString();
    }
    // 어느 게시글의 위시리스트(찜) 여부에 따라 다르게
    public static String generateWishListId(String category){
        return "wishlist_"+category+"_"+UUID.randomUUID().toString();
    }
    // 어느 게시글의 댓글인지 여부에 따라 다르게
    public static String generateReplyId(String category){
        return "reply_"+category+"_"+UUID.randomUUID().toString();
    }

}
