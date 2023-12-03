package com.festival.festival.controller.user;

import com.festival.festival.auth.PrincipalDetails;
import com.festival.festival.dto.ExpDTO;
import com.festival.festival.dto.ReserveDTO;
import com.festival.festival.dto.UserDTO;
import com.festival.festival.entity.User;
import com.festival.festival.service.ExpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservation")
@Log4j2
public class ReservationController {

    @Autowired
    private ExpService expService;

    @GetMapping("")
    public String reservation(@RequestParam(value = "idx") Long idx, Authentication authentication, Model model) {

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();

        ExpDTO expDTO = expService.read(idx);

        model.addAttribute("user", user);
        model.addAttribute("dto", expDTO);

        return "/reservation/reservation";
    }

    @PostMapping("")
    public String reserveInsert(ReserveDTO reserveDTO) {
        log.info("post로 넘어오는 값들 확인!!" + reserveDTO); // ok


        return "redirect:/reservation/result";
    }

    @GetMapping("/result")
    public String reservationResult() {
        return "/reservation/reservation-result";
    }
}
