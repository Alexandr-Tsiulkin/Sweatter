package com.gmail.tsiulkin.alexandr.controller;

import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.UserService;
import com.gmail.tsiulkin.alexandr.service.model.EditUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.RoleEnum;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<ShowUserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{user}")
    public String userEdit(
            @PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", RoleEnum.values());
        return "user-edit";
    }

    @PostMapping("/users")
    public String userEdit(EditUserDTO editUser) {
        userService.edit(editUser);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{user}")
    public String deleteUser(
            @PathVariable User user) {
        userService.isDeleted(user);
        return "redirect:/users";
    }
}
