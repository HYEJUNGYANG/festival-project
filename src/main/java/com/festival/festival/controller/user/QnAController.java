package com.festival.festival.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna")
@Log4j2
public class QnAController {
    @GetMapping("")
    public String list() {
        return "/qna/qna";
    }

    @GetMapping("/write")
    public String write() {
        return "/qna/qna-write";
    }
}
