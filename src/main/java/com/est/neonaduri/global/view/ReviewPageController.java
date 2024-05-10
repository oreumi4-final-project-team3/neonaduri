package com.est.neonaduri.global.view;

import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.service.PostImagesService;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostViewResponse;
import com.est.neonaduri.domain.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ReviewPageController {
    private final PostsService postsService;
    private final PostImagesService postImagesService;

    //KEC
    @GetMapping("/reviews")
    public String getAllReview(Model model,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);
        model.addAttribute("reviews", postsService.getPostListByCategory("review", pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "all");
        return "reviewList";
    }

    @GetMapping("/reviews/{areaCode}")
    public String getReviewByAreaCode(@PathVariable int areaCode
            , Model model
            , @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "12") int size) {

        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);
        model.addAttribute("reviews", postsService.getPostListByCategoryAndAreaCode("review", areaCode, pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "region");
        model.addAttribute("areaCode", areaCode);
        return "reviewList";
    }



    //CJW
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

