package com.est.neonaduri.global.view;

import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.service.PostImagesService;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostViewResponse;
import com.est.neonaduri.domain.posts.service.PostsService;
import com.est.neonaduri.global.config.auth.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
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
    private final HttpSession httpSession;

    //KEC
    @GetMapping("/reviews")
    public String getAllReview(Model model,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);
        model.addAttribute("reviews", postsService.getPostListByCategory("review", pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "all");

        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        if(sessionUser != null){
            model.addAttribute("sessionUser",sessionUser);
        }

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

        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        if(sessionUser != null){
            model.addAttribute("sessionUser",sessionUser);
        }

        return "reviewList";
    }

    //CJW
    @GetMapping("/reviews/id/{postId}")
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

        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        if(sessionUser != null){
            model.addAttribute("sessionUser",sessionUser);
        }

        return "review";
    }

    @GetMapping("/uploadReview")
    public String uploadReview(){
        return "uploadReview";
    }

    //생성, 수정 같이 작동 부분 -> 아직 연결 X
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