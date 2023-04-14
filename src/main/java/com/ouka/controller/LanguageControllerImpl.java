package com.ouka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("languageController")
public class LanguageControllerImpl implements LanguageController {
    @GetMapping("/home/{lang}")
    @Override
    public String getLanguage(Model model,
                              @PathVariable String lang) {
        return "language/" + lang;
    }
}
