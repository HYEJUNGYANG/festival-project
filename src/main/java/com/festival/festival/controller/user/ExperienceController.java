package com.festival.festival.controller.user;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.service.ExpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/experience")
@Log4j2
public class ExperienceController {

    @Autowired
    private ExpService expService;


    @GetMapping("")
    public String list() {
        log.info("체험 리스트 페이지");
        return "/experience/experience";
    }

    @GetMapping("/detail")
//    defaultValue 임시로 넣은거라서 나중에 테스트 완료되면 뺄 것!
    public String detail(@RequestParam(value = "idx", defaultValue = "10") Long idx, Model model) {

        ExpDTO expDTO = expService.read(idx);
        model.addAttribute("dto", expDTO);

        return "/experience/experience-detail";
    }
}
