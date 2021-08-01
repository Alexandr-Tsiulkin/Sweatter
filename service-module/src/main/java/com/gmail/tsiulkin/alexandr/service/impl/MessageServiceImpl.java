package com.gmail.tsiulkin.alexandr.service.impl;

import com.gmail.tsiulkin.alexandr.repository.MessageRepository;
import com.gmail.tsiulkin.alexandr.repository.UserRepository;
import com.gmail.tsiulkin.alexandr.repository.model.Message;
import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.MessageService;
import com.gmail.tsiulkin.alexandr.service.converter.MessageConverter;
import com.gmail.tsiulkin.alexandr.service.exception.NotFoundException;
import com.gmail.tsiulkin.alexandr.service.model.AddMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.UserLogin;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageConverter messageConverter;
    private final UserRepository userRepository;

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
    public void persist(AddMessageDTO addMessageDTO, UserLogin user) throws NotFoundException {
        Message message = messageConverter.convert(addMessageDTO);
        User userByUsername = userRepository.findByUsername(user.getUsername());
        if (Objects.nonNull(userByUsername)) {
            message.setAuthor(userByUsername);
            messageRepository.save(message);
        } else {
            throw new NotFoundException(String.format("User with username: %s was not found", user.getUsername()));
        }
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
