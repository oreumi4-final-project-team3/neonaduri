package com.est.neonaduri.domain.postImages.repository;

import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImagesRepository extends JpaRepository<PostImages, String> {
    PostImages findPostImagesByPosts(Posts post);
}
