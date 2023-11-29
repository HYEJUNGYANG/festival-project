package com.festival.festival.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
@Log4j2
public class ReservationController {

    @GetMapping("")
    public String reservation() {
        return "/reservation/reservation";
    }

    @GetMapping("/result")
    public String reservationResult() {
        return "/reservation/reservation-result";
    }
}
