package com.gmail.tsiulkin.alexandr.service.converter.impl;

import com.gmail.tsiulkin.alexandr.repository.model.Message;
import com.gmail.tsiulkin.alexandr.service.converter.MessageConverter;
import com.gmail.tsiulkin.alexandr.service.model.AddMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowMessageDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageConverterImpl implements MessageConverter {

    @Override
    public ShowMessageDTO convert(Message message) {
        ShowMessageDTO showMessageDTO = new ShowMessageDTO();
        showMessageDTO.setId(message.getId());
        showMessageDTO.setText(message.getText());
        showMessageDTO.setTag(message.getTag());
        return showMessageDTO;
    }

    @Override
    public Message convert(AddMessageDTO addMessageDTO) {
        Message message = new Message();
        message.setText(addMessageDTO.getText());
        message.setTag(addMessageDTO.getTag());
        return message;
    }
}
