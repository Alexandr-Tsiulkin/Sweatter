package com.gmail.tsiulkin.alexandr.repository;

import com.gmail.tsiulkin.alexandr.repository.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAll();

    Message save(Message message);

    List<Message> findByTag(String tag);
}
