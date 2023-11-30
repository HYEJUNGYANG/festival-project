package com.festival.festival.controller.user;

import com.festival.festival.dto.UserDTO;
import com.festival.festival.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/join")
@Log4j2
@RequiredArgsConstructor
public class JoinController {

    private final UserService userService;

    @GetMapping("")
    public String join() {
        return "join";
    }

    @PostMapping("/check_id")
    @ResponseBody
    public UserDTO checkId(String id) {
        UserDTO dto = userService.read(id);
        log.info(id);
        return dto;
    }

//    @PostMapping("")
//    @ResponseBody
//    public UserDTO  test(String id) {
//        log.info("넘어온 ID 값!! " + id);
//        UserDTO dto = userService.read(id);
//        return dto;
//    }
}
