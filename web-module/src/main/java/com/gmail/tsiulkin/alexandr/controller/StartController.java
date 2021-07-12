package com.gmail.tsiulkin.alexandr.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class StartController {

    @GetMapping
    public String getStartPage() {
        return "home";
    }
}
