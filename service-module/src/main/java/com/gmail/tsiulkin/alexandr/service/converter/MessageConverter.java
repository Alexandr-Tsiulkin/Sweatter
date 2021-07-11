package com.gmail.tsiulkin.alexandr.service.converter;

import com.gmail.tsiulkin.alexandr.repository.model.Message;
import com.gmail.tsiulkin.alexandr.service.model.AddMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowMessageDTO;

public interface MessageConverter {

    ShowMessageDTO convert(Message message);

    Message convert(AddMessageDTO addMessageDTO);
}
