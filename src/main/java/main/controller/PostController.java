package main.controller;

import lombok.RequiredArgsConstructor;
import main.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    @GetMapping("/getAllPosts")
    String getAllPosts(Model model){
        model.addAttribute("getAllPosts", postService.getAllPosts());
        return "/getAllPosts";
    }
}
