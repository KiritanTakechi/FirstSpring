package com.ouka.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface RegisterController {
    public String getRegister(Model model,
                              @RequestParam(name = "username", required = false) String username,
                              @RequestParam(name = "password", required = false) String password);

    public String postRegister(Model model,
                               @RequestParam(name = "nickname", required = false) String nickname,
                               @RequestParam(name = "username", required = false) String username,
                               @RequestParam(name = "password", required = false) String password);
}
