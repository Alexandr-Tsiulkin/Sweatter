package com.gmail.tsiulkin.alexandr.repository;

import com.gmail.tsiulkin.alexandr.repository.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername (String username);
}
