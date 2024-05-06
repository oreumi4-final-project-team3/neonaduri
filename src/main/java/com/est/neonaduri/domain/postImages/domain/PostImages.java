package com.est.neonaduri.domain.postImages.domain;

import com.est.neonaduri.domain.posts.domain.Posts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "POST_IMAGES")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostImages {
    @Id
    @Column(name = "IMG_LINK", length = 100, nullable = false)
    private String postImagesId;

    @OneToOne
    @JoinColumn(name = "POST_ID", nullable = false)
    private Posts posts;
}
