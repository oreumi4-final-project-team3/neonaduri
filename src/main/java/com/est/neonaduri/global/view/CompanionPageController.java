package com.est.neonaduri.global.view;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.companions.service.CompanionsService;
import com.est.neonaduri.domain.postImages.domain.PostImages;
import com.est.neonaduri.domain.postImages.service.PostImagesService;
import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostViewResponse;
import com.est.neonaduri.domain.posts.service.PostsService;
import com.est.neonaduri.domain.spots.dto.SpotPageDto;
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
public class CompanionPageController {
    private final CompanionsService companionsService;
    private final PostImagesService postImagesService;
    private final PostsService postsService;


    @GetMapping("/companions")
    public String getAllCompanions(Model model,
                                   @RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);

        model.addAttribute("companions", companionsService.getAllCompanions(pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "region");
        return "companions";
    }

    @GetMapping("/companions/{areaCode}")
    public String getCompanionsByAreaCode(@PathVariable int areaCode, Model model,
                                          @RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size);

        model.addAttribute("companions", companionsService.getCompanionsByAreaCode(areaCode, pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageType", "region");

        return "companions";
    }

    @GetMapping("/companions/id/{comId}")
    public String showCompanion(@PathVariable String comId, Model model){
        Companions companion = companionsService.findById(comId);
        PostImages img = postImagesService.findPostImages(companion.getPosts().getPostId());

        model.addAttribute("companion",companion);
        model.addAttribute("post",companion.getPosts());
        model.addAttribute("user",companion.getPosts().getUsers());

        if(img==null){
            //사진 없을 경우 기본 이미지
            model.addAttribute("img_link","/images/companionTestImg.png");
        }
        else{
            model.addAttribute("img_link",img.getPostImagesId());
        }

        return "companionsDetail";
    }
    @GetMapping("/companions/postId/{postId}")
    public String showCompanionByPostId(@PathVariable String postId, Model model){
        Companions companion = companionsService.findByPostId(postId);
        PostImages img = postImagesService.findPostImages(companion.getPosts().getPostId());

        model.addAttribute("companion",companion);
        model.addAttribute("post",companion.getPosts());
        model.addAttribute("user",companion.getPosts().getUsers());

        if(img==null){
            //사진 없을 경우 기본 이미지
            model.addAttribute("img_link","/images/companionTestImg.png");
        }
        else{
            model.addAttribute("img_link",img.getPostImagesId());
        }

        return "companionsDetail";
    }

    @GetMapping("/uploadCompanion")
    public String uploadCompanion(Model model) {
        model.addAttribute("post",new PostViewResponse());
        return "uploadCompanion";
    }

    @GetMapping("/uploadCompanion/{postId}")
    public String uploadCompanionByPostId (@PathVariable String postId, Model model){
        Posts post = postsService.findById(postId);
        model.addAttribute("post",post);

        return "uploadCompanion";
    }

}
