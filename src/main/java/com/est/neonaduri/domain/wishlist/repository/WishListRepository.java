package com.est.neonaduri.domain.wishlist.repository;

import java.util.List;

import com.est.neonaduri.domain.wishlist.domain.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<Wishlist, String> {
	List<Wishlist> findAllByUsersUserId(String userId);
}
