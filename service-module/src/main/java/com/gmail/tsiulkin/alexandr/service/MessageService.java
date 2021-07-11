package com.gmail.tsiulkin.alexandr.service;

import com.gmail.tsiulkin.alexandr.service.model.AddMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowMessageDTO;

import java.util.List;

public interface MessageService {

    List <ShowMessageDTO> getAllMessages();

    void persist(AddMessageDTO addMessageDTO);

    List <ShowMessageDTO> findMessageByTag(String tag);
}
