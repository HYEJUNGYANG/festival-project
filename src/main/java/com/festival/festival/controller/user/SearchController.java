package com.festival.festival.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@Log4j2
public class SearchController {
    @GetMapping("/search")
    public String search(@RequestParam(value = "q", required = false)String q, Model model) {
        return "search";
    }
}
