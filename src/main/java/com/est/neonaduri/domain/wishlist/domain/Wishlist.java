package com.est.neonaduri.domain.wishlist.domain;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "WISHLIST")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wishlist {
    @Id
    @Column(name = "WISH_ID", length = 100, nullable = false)
    private String wishId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "POST_ID", nullable = false)
    private Posts posts;

    @PrePersist
    public void prePersist(){
        this.wishId = IdGenerator.generateWishListId();
    }
}
