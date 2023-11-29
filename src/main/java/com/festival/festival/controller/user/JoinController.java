package com.festival.festival.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
@Log4j2
public class JoinController {
    @GetMapping("")
    public String join() {
        return "join";
    }
}
