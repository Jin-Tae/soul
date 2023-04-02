package com.soulbrain.cicd.soulbrain.cicd.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/soulbrain")
public class SoulbrainController {



    @GetMapping("/")
    public String view(Model model) {
        return "index";
    }

    @GetMapping("/homepage")
    public String homepage(Model model) {
        return "soulbrain";
    }

    @GetMapping("/notion")
    public String notion(Model model) {
        return "notion";
    }
}
