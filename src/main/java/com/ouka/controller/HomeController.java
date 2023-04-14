package com.ouka.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface HomeController {
    public String getHome(Model model,
                          HttpSession session);

    public String postHome(Model model);

}
