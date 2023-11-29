package com.festival.festival.controller.user;

import com.festival.festival.dto.FestivalDTO;
import com.festival.festival.entity.Festival;
import com.festival.festival.service.FestivalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/festival")
@Log4j2
@RequiredArgsConstructor
public class FestivalController {

    @Autowired
    private final FestivalService festivalService;

    @GetMapping("")
    public String list(@RequestParam(value = "zone", defaultValue = "전체") String zone, Model model) {

        List<Festival> dto = festivalService.getList(zone);
        model.addAttribute("dto", dto);
        return "/festival/festival";
    }

    @GetMapping("/detail")
    //    defaultValue 임시로 넣은거라서 나중에 테스트 완료되면 뺄 것!
    public String detail(@RequestParam(value = "idx", defaultValue = "1") Long idx, Model model) {
        if (idx != null) {
            FestivalDTO festivalDTO = festivalService.read(idx);
            model.addAttribute("dto", festivalDTO);
        }
        return "/festival/festival-detail";
    }
}
