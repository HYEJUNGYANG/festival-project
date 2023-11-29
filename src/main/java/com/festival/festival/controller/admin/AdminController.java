package com.festival.festival.controller.admin;


import com.festival.festival.dto.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Log4j2
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("admin_page/admin_login")
    public void login_admin(PageRequestDTO pageRequestDTO, Model model) {
        log.info("pageRequestDTO:" + pageRequestDTO);
        model.addAttribute("result");
    }
    @GetMapping("admin_page/admin_main")
    public void main_admin(PageRequestDTO pageRequestDTO, Model model) {
        log.info("pageRequestDTO:" + pageRequestDTO);
        model.addAttribute("result");
    }

}
