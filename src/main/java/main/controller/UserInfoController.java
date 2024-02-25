package main.controller;

import lombok.RequiredArgsConstructor;
import main.entity.UserInfo;
import main.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/userInfos")
public class UserInfoController {
    private final UserInfoService userInfoService;
    @GetMapping
    public String getUserInfo (Model model, Model model1){
        model.addAttribute("userInfo", new UserInfo());
        model.addAttribute("currentUser", UserController.currentUser);
        return "/profile";
    }
}
