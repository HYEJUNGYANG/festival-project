package com.festival.festival.controller.admin;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.entity.Exp;
import com.festival.festival.service.ExpService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Log4j2
@RequiredArgsConstructor
public class ExpController {

    private final ExpService expService;

    @GetMapping("admin_page/exp_list")//리스트 불러오기
    public void exp_review(PageRequestDTO pageRequestDTO, Model model, String keyword) {
        log.info("pageRequestDTO:" + pageRequestDTO);
        int page = pageRequestDTO.getPage();
        int pageNum = 10 * (page - 1);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("result",expService.getList(pageRequestDTO));
    }

    @GetMapping("/admin_page/exp_detail")
    public void read(Long idx, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {

        log.info("idx : " + idx);
        ExpDTO dto = expService.read(idx);
        model.addAttribute("dto", dto);
    }

    @GetMapping("/admin_page/exp_writedo")
    public String writeExp(){
        return "/admin_page/exp_write";
    }

    @PostMapping("/admin_page/exp_insertdo")
    public String insertExp(Exp exp){

        expService.insertExp(exp);
        return "redirect:/admin_page/exp_list";

    }

    @GetMapping("/admin_page/exp_delete")
    public String deleteExp(Long idx){

        expService.deleteExp(idx);
        return "redirect:/admin_page/exp_list";
    }


    @GetMapping("/admin_page/exp_modify")
    public void modifyExp(Long idx, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){


        log.info("idx : "+ idx);
        ExpDTO dto = expService.read(idx);
        model.addAttribute("dto", dto);

    }

    // post 방식이라 같아도 상관없음!!
    @Transactional
    @PostMapping("/admin_page/exp_modify")
    public String modify2(ExpDTO dto){

        expService.modifyExp(dto);
        return "redirect:/admin_page/exp_list";

    }




}