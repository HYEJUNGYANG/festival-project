package com.festival.festival.controller.user;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.entity.Exp;
import com.festival.festival.entity.Review;
import com.festival.festival.service.ExpService;
import com.festival.festival.service.ReviewService;
import com.querydsl.core.Tuple;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/experience")
@Log4j2
public class ExperienceController {

    @Autowired
    private ExpService expService;
    @Autowired
    private ReviewService reviewService;


    @GetMapping("")
    public String list(@RequestParam(value = "zone", defaultValue = "전체") String zone, Model model) {
        List<Exp> dto = expService.getList(zone);
        model.addAttribute("dto", dto);

        return "/experience/experience";
    }

    @GetMapping("/detail")
//    defaultValue 임시로 넣은거라서 나중에 테스트 완료되면 뺄 것!
    public String detail(@RequestParam(value = "idx", defaultValue = "10") Long idx, Model model) {

        ExpDTO expDTO = expService.read(idx);
        List<Review> reviewDto = reviewService.getList(idx);
        model.addAttribute("dto", expDTO);
        model.addAttribute("review", reviewDto);

        return "/experience/experience-detail";
    }
}
