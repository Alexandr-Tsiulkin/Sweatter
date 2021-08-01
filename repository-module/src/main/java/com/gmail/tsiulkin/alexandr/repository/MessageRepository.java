package com.gmail.tsiulkin.alexandr.repository;

import com.gmail.tsiulkin.alexandr.repository.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAll();

    Message save(Message message);

    List<Message> findByTag(String tag);
}
