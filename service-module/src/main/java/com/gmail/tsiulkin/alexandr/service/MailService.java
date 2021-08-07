package com.gmail.tsiulkin.alexandr.service;

import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;

public interface MailService {

    void sendMailAfterRegistration(ShowUserDTO showUser);
}
