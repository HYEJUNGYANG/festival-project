package com.festival.festival.controller.admin;

import com.festival.festival.dto.FestivalDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.service.FestivalService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/")
@Log4j2
@RequiredArgsConstructor
public class FestivalController {

    @Autowired
    private final FestivalService festivalService;


    @GetMapping("admin_page/festival_list")//리스트 불러오기
    public void list_festival(PageRequestDTO pageRequestDTO, Model model, String keyword) {
        log.info("pageRequestDTO:" + pageRequestDTO);
        int page = pageRequestDTO.getPage();
        int pageNum = 10 * (page - 1);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("result",festivalService.getList(pageRequestDTO));
    }


    @GetMapping("/admin_page/festival_detail")
    public void read(Long idx, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {

        log.info("idx : " + idx);
        FestivalDTO dto = festivalService.read(idx);
        model.addAttribute("dto", dto);
    }

    @GetMapping("/admin_page/festival_writedo")
    public String writeFestival(){
        return "/admin_page/festival_write";
    }

    @PostMapping("/admin_page/festival_insertdo")
    public String insertFestival(FestivalDTO dto, RedirectAttributes redirectAttributes, Model model, MultipartFile file) throws IOException {

     /*   festivalService.insertFestival(festival);*/
        //새로 추가된 엔티티의 번호
        Long ip = festivalService.join(dto,file);
        redirectAttributes.addFlashAttribute("msg",ip);

        return "redirect:/admin_page/festival_list";

    }

    @GetMapping("/admin_page/festival_delete")
    public String deleteFestival(Long idx){

        festivalService.deleteFestival(idx);
        return "redirect:/admin_page/festival_list";
    }



    @GetMapping("/admin_page/festival_modify")
    public void modifyFestival(Long idx, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {

        log.info("idx : " + idx);
        FestivalDTO dto = festivalService.read(idx);
        model.addAttribute("dto", dto);

    }

    @Transactional
    @PostMapping("/admin_page/festival_modify")
    public String modify2(FestivalDTO dto){

        festivalService.modifyFestival(dto);
        return "redirect:/admin_page/festival_list";

    }



}
