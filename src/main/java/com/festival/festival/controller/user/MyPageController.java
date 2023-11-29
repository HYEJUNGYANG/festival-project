package com.festival.festival.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @GetMapping({"", "/profile"})
    public String modify() {
        return "/mypage/mypage-profile";
    }

    @GetMapping("/profile/pw-change")
    public String pwChange() {
        return "/mypage/pw-change";
    }

    @GetMapping("/favorite")
    public String favorite() {
        return "/mypage/mypage-favorite";
    }

    @GetMapping("/reservation")
    public String reservation() {
        return "/mypage/mypage-reservation";
    }

    @GetMapping("/reservation/detail")
    public String reservationDetail() {
        return "/mypage/mypage-reservation-detail";
    }

    @GetMapping("/review")
    public String review() {
        return "/mypage/mypage-review";
    }

    @GetMapping("/review/write")
    public String reviewWrite() {
        return "/mypage/review-write";
    }

}
