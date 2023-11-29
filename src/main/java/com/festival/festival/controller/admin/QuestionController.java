package com.festival.festival.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Log4j2
@RequiredArgsConstructor
public class QuestionController {

/*

    @Autowired
    private final QuestionService questionService;

    @GetMapping("admin_page/qa_list")
    public void list_qa(PageRequestDTO pageRequestDTO, Model model){
        log.info("pageRequestDTO:" + pageRequestDTO);
        model.addAttribute("result", questionService.getList(pageRequestDTO));
    }

    @GetMapping("/admin_page/qa_detail")
    public void read(Long idx, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {

        log.info("idx : " + idx);
        ExpDTO dto = questionService.read(idx);
        model.addAttribute("dto", dto);
    }
*/


}