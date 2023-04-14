package com.ouka.controller;

import com.ouka.model.User;
import com.ouka.service.HomeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("homeController")
public class HomeControllerImpl implements HomeController {
    @Resource
    private HomeService homeService;

    @GetMapping("/home")
    @Override
    public String getHome(Model model,
                          HttpSession session) {
        return "home";

        /*User user = (User) session.getAttribute("user");
        if (user != null && homeService.isLogin(user)) {
            return "home";
        } else {
            return "redirect:/login";
        }*/
    }

    @PostMapping("/home")
    @Override
    public String postHome(Model model) {
        return null;
    }
}
