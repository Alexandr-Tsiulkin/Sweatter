package com.gmail.tsiulkin.alexandr.service.impl;

import com.gmail.tsiulkin.alexandr.repository.MessageRepository;
import com.gmail.tsiulkin.alexandr.repository.model.Message;
import com.gmail.tsiulkin.alexandr.service.MessageService;
import com.gmail.tsiulkin.alexandr.service.converter.MessageConverter;
import com.gmail.tsiulkin.alexandr.service.model.AddMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowMessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageConverter messageConverter;

    @Override
    @Transactional
    public List<ShowMessageDTO> getAllMessages() {
        List<Message> allMessages = messageRepository.findAll();
        return allMessages.stream()
                .map(messageConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void persist(AddMessageDTO addMessageDTO) {
        Message message = messageConverter.convert(addMessageDTO);
        messageRepository.save(message);
    }

    @Override
    public List<ShowMessageDTO> findMessageByTag(String tag) {
        List<Message> messagesByTag;
        if (StringUtils.hasText(tag)) {
            messagesByTag = messageRepository.findByTag(tag);
        } else {
            messagesByTag = messageRepository.findAll();
        }
        return messagesByTag.stream()
                .map(messageConverter::convert)
                .collect(Collectors.toList());
    }


}
