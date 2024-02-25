package main.controller;

import lombok.RequiredArgsConstructor;
import main.ForLogin;
import main.entity.Post;
import main.entity.User;
import main.entity.UserInfo;
import main.service.PostService;
import main.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final PostService postService;
    public static User currentUser = null;


    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("newUser", new User());
        return "/signUp";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user) {
        UserInfo userInfo = new UserInfo();
        user.setUserInfo(userInfo);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping()
    public String signIn(Model model) {
        model.addAttribute("information", new ForLogin());
        return "signIn";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("information") ForLogin forLogin, Model model, Model currentUser1) {
        if (userService.login(forLogin) == null) throw new RuntimeException();
        else {
            model.addAttribute("posts", postService.getAllPosts());
            currentUser = userService.login(forLogin);
            currentUser1.addAttribute("currentUser", currentUser);
            return "/mainPage";
        }
    }
    @GetMapping("/mainPage")
    public String mainPage(Model model, Model model1){
        model.addAttribute("posts",postService.getAllPosts());
        model1.addAttribute("currentUser",currentUser);
        return "/mainPage";
    }

}
