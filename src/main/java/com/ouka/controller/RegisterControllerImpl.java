package com.ouka.controller;

import com.ouka.service.RegisterService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("registerController")
public class RegisterControllerImpl implements RegisterController {
    @Resource
    private RegisterService registerService;

    @GetMapping(value = "/register")
    @Override
    public String getRegister(Model model,
                              @RequestParam(name = "username", required = false) String username,
                              @RequestParam(name = "password", required = false) String password) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "register";
    }

    @PostMapping(value = "/register")
    @Override
    public String postRegister(Model model,
                               @RequestParam(name = "nickname", required = false) String nickname,
                               @RequestParam(name = "username", required = false) String username,
                               @RequestParam(name = "password", required = false) String password) {
        if (registerService.isRegistered(username)) {
            model.addAttribute("registerErrorMessage", "用户名已存在，请重新输入。");
            return "register";
        } else {
            if (registerService.register(nickname, username, password)) {
                return "redirect:/login";
            } else {
                model.addAttribute("registerErrorMessage", "未知错误。");
                return "register";
            }
        }
    }
}
