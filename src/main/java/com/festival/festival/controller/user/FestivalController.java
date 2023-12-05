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

import java.util.ArrayList;
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

            //@@1@@로 되어있는 태그를 #1,#2로 변환
            String savedTags = festivalDTO.getTag(); // 데이터베이스에서 읽어온 해시태그

            String[] tags = savedTags.split("@@"); // "@@"로 해시태그 분리

            List<String> taglist = new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            for (String tag : tags) {
                if (!tag.isEmpty()) {
                    taglist.add("#"+tag); // 각 해시태그에서 "@@"를 제거하고 "#"을 추가하여 StringBuilder에 추가
                }
            }
            String tag = sb.toString(); // 변환된 형식인 "#12,#34,#56" 형태의 문자열

            model.addAttribute("taglist", taglist);
            model.addAttribute("dto", festivalDTO);
        }
        return "/festival/festival-detail";
    }
}
