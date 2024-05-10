package com.est.neonaduri.global.view;

import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.service.PostImagesService;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostViewResponse;
import com.est.neonaduri.domain.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewPageController {
    private final PostsService postsService;
    private final PostImagesService postImagesService;

    @GetMapping("/reviews")
    public String getReviews(Model model) {
        List<PostViewResponse> reviews = postsService.findAllByCategory("review").stream()
                .map(PostViewResponse::new)
                .toList();
        model.addAttribute("reviews", reviews);

        return "reviews";
    }

    @GetMapping("/reviews/{postId}")
    public String showReview(@PathVariable String postId, Model model) {
        Posts review = postsService.findById(postId);
        model.addAttribute("review", review);

        PostImages img = postImagesService.findPostImages(postId);

        if(img==null){
            //사진 없을 경우 기본 이미지
            model.addAttribute("img_link","https://neonaduri.s3.ap-northeast-2.amazonaws.com/neonaduri_logo.png");
        }
        else{
            model.addAttribute("img_link",img.getPostImagesId());
        }

        return "review";
    }

    @GetMapping("/new-review")
    public String newReview(@RequestParam(required = false) String id, Model model) {
        if (id == null) {
            model.addAttribute("review",new PostViewResponse());
        } else{
            Posts post = postsService.findById(id);
            model.addAttribute("review", new PostViewResponse(post));
        }
        return "newReview";
    }

    @GetMapping("/uploadReview")
    public String uploadReview(){
        return "uploadReview";
    }
}
