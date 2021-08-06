package com.gmail.tsiulkin.alexandr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping(value = "/home")
    public String getHomePage(){
        return "home-admin";
    }
}
