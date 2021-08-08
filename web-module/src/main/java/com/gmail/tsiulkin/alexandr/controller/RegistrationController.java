package com.gmail.tsiulkin.alexandr.controller;

import com.gmail.tsiulkin.alexandr.service.MailService;
import com.gmail.tsiulkin.alexandr.service.UserService;
import com.gmail.tsiulkin.alexandr.service.exception.UserAlreadyExistsException;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final MailService mailService;

    @GetMapping("/registration")
    public String getStartPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(AddUserDTO user, Model model) throws UserAlreadyExistsException {
        ShowUserDTO showUser = userService.save(user);
        mailService.sendMailForActivationUser(showUser);
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activateEmail(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);
        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "activation code was not found");
        }
        return "login";
    }

}
