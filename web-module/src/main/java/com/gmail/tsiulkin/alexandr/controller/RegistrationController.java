package com.gmail.tsiulkin.alexandr.controller;

import com.gmail.tsiulkin.alexandr.service.UserService;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public String getStartPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(AddUserDTO user, Model model){
        if (!userService.save(user)){
            model.addAttribute("error", "User with this username exists");
            return "registration";
        }
        return "redirect:/login";
    }

}
