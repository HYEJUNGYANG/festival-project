package com.festival.festival.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
@Log4j2
public class SearchController {
    @GetMapping("")
    public String search() {
        return "search";
    }
}
