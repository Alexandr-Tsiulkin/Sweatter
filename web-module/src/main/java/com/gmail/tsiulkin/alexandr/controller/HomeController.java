package com.gmail.tsiulkin.alexandr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping(value = "/home-admin")
    public String getHomePageAdmin(){
        return "home-admin";
    }

    @GetMapping(value = "/home-user")
    public String getHomePageUser(){
        return "home-user";
    }
}
