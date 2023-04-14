package com.ouka.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface LoginController {
    public String getLogin(Model model,
                           HttpSession session,
                           @RequestParam(name = "nickname", required = false) String nickname,
                           @RequestParam(name = "username", required = false) String username,
                           @RequestParam(name = "password", required = false) String password);

    public String postLogin(Model model,
                            HttpSession session,
                            HttpServletResponse response,
                            @RequestParam(name = "username", required = false) String username,
                            @RequestParam(name = "password", required = false) String password);
}
