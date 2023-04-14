package com.ouka.controller;

import com.ouka.model.User;
import com.ouka.service.LoginService;
import com.ouka.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller("loginController")
public class LoginControllerImpl implements LoginController {
    @Resource
    private UserService userService;
    @Resource
    private LoginService loginService;

    @GetMapping(value = "/login")
    @Override
    public String getLogin(Model model,
                           HttpSession session,
                           @RequestParam(name = "nickname", required = false) String nickname,
                           @RequestParam(name = "username", required = false) String username,
                           @RequestParam(name = "password", required = false) String password) {
        var user = (User) session.getAttribute("user");
        if (user != null && loginService.isLogin(user)) {
            model.addAttribute("nickname", user.getNickname());
            model.addAttribute("username", user.getUsername());
            return "sign";
        } else if (nickname != null || username != null || password != null) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "login";
        } else {
            return "login";
        }
    }

    @PostMapping(value = "/login")
    @Override
    public String postLogin(Model model,
                            HttpSession session,
                            HttpServletResponse response,
                            @RequestParam(name = "username", required = false) String username,
                            @RequestParam(name = "password", required = false) String password) {
        if (loginService.login(username, password) && (!Objects.equals(username, "") && !Objects.equals(password, ""))) {
            var user = userService.getUserByUsername(username);
            session.setAttribute("user", user);
            Cookie cookie = new Cookie("sessionId", session.getId());
            cookie.setMaxAge(300); // 5 min
            response.addCookie(cookie);
            model.addAttribute("nickname", user.getNickname());
            model.addAttribute("username", user.getUsername());
            return "sign";
        } else {
            model.addAttribute("loginErrorMessage", "用户名或密码错误。");
            return "login";
        }
    }
}
