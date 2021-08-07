package com.gmail.tsiulkin.alexandr.service.impl;

import com.gmail.tsiulkin.alexandr.service.MailService;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String recipientMail;

    @Override
    public void sendMailAfterRegistration(ShowUserDTO showUser) {
        SimpleMailMessage message = getMailMessageForAddUser(showUser, recipientMail);
        javaMailSender.send(message);
    }

    private SimpleMailMessage getMailMessageForAddUser(ShowUserDTO showUser, String recipientMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientMail);
        message.setSubject(String.format("Welcome to Sweatter, %s", showUser.getUsername()));
        message.setText(String.format("Hello, %s! Your account was successfully created", showUser.getUsername()));
        return message;
    }
}
