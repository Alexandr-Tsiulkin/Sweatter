package com.gmail.tsiulkin.alexandr.service.impl;

import com.gmail.tsiulkin.alexandr.service.MailService;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMailForActivationUser(ShowUserDTO showUser) {
        SimpleMailMessage message = getMailMessageForAddUser(showUser);
        javaMailSender.send(message);
    }

    private SimpleMailMessage getMailMessageForAddUser(ShowUserDTO showUser) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(showUser.getUsername());
        message.setSubject("Activation code");
        message.setText(String.format("Hello, %s! \n" +
                        "Welcome to Sweatter. Please, click this link for activate your email: http://localhost:8080/activate/%s",
                showUser.getUsername(), showUser.getActivationCode()));
        return message;
    }
}
