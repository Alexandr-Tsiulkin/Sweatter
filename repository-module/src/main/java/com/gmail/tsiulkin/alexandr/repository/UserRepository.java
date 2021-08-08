package com.gmail.tsiulkin.alexandr.repository;

import com.gmail.tsiulkin.alexandr.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername (String username);

    User findByActivatedCode(String code);
}
