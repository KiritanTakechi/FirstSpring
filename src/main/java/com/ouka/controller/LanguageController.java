package com.ouka.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

public interface LanguageController {
    public String getLanguage(Model model,
                              @PathVariable String lang);
}
