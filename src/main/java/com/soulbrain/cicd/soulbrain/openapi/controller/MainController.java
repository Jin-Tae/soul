package com.soulbrain.cicd.soulbrain.openapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main_api(Model model) {
        return "api/api";
    }
}
