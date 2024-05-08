package com.est.neonaduri.global.view;

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

    @GetMapping("/reviews")
    public String getReviews(Model model) {
        List<PostViewResponse> reviews = postsService.findAllByCategory("review").stream()
                .map(PostViewResponse::new)
                .toList();
        model.addAttribute("reviews", reviews);

        return "reviews";
    }

    @GetMapping("/reviews/{id}")
    public String showReview(@PathVariable String id, Model model) {
        Posts review = postsService.findById(id);
        model.addAttribute("review", new PostViewResponse(review));

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
}

