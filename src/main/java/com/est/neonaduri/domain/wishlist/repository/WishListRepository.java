package com.est.neonaduri.domain.wishlist.repository;

import java.util.List;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.wishlist.domain.Wishlist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<Wishlist, String> {
	Page<Wishlist> findAllByUsersUserId(String userId, Pageable pageable);
	Integer countAllByPosts(Posts posts);
}
