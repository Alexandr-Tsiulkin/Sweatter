package com.gmail.tsiulkin.alexandr.service;

import com.gmail.tsiulkin.alexandr.service.exception.NotFoundException;
import com.gmail.tsiulkin.alexandr.service.model.AddMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.UserLogin;

import java.util.List;

public interface MessageService {

    List <ShowMessageDTO> getAllMessages();

    void persist(AddMessageDTO addMessageDTO, UserLogin user) throws NotFoundException;

    List <ShowMessageDTO> findMessageByTag(String tag);
}
