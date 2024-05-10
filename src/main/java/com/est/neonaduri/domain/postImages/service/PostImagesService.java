package com.est.neonaduri.domain.postImages.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.repository.PostImagesRepository;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class PostImagesService {
    private final PostImagesRepository postImagesRepository;
    private final PostsRepository postsRepository;

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.region}")
    private String region;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    //save spots img
    public PostImages createPostImages(String imgLink, Posts post) {
        return postImagesRepository.save(PostImages.builder()
                .postImagesId(imgLink)
                .posts(post)
                .build());
    }

    public PostImages findPostImages(String postId){
        Posts posts = postsRepository.findByPostId(postId);
        return postImagesRepository.findPostImagesByPosts(posts);
    }

    //S3
    public PostImages uploadImg(MultipartFile file, Posts post) throws IOException {
        if (file.isEmpty()) {
            return null;
        }

        String key = file.getOriginalFilename();

        amazonS3.putObject(makeRequest(file));

        //암호화, 분류 해서 추가 필요
        String postImagesId = amazonS3.getUrl(bucketName, key).toString();

        return postImagesRepository.save(PostImages.builder()
                .postImagesId(postImagesId)
                .posts(post)
                .build());
    }

    private PutObjectRequest makeRequest(MultipartFile file) throws IOException {
        String key = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        ObjectMetadata metadata = new ObjectMetadata();

        PutObjectRequest request = new PutObjectRequest(bucketName, key, inputStream, metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead);

        return request;
    }
    public Posts getPosts(String postId){
        return postImagesRepository.findById(postId).orElseThrow().getPosts();
    }
}
