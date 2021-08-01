package com.gmail.tsiulkin.alexandr.controller;

import com.gmail.tsiulkin.alexandr.service.MessageService;
import com.gmail.tsiulkin.alexandr.service.exception.NotFoundException;
import com.gmail.tsiulkin.alexandr.service.model.AddMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.UserLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/messages")
    public String getMessages(Model model) {
        List<ShowMessageDTO> messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "messages";
    }

    @PostMapping("/messages")
    public String filter(@RequestParam String filter, Model model) {
        List<ShowMessageDTO> messagesByTag = messageService.findMessageByTag(filter);
        model.addAttribute("messages", messagesByTag);
        return "messages";
    }

    @GetMapping("/messages/add")
    public String addPage(Model model) {
        model.addAttribute("AddMessage", new AddMessageDTO());
        return "add-message";
    }

    @PostMapping("/messages/add")
    public String add(
            @AuthenticationPrincipal UserLogin user,
            @Valid AddMessageDTO addMessageDTO) throws NotFoundException {
        messageService.persist(addMessageDTO, user);
        return "redirect:/messages";
    }
}
