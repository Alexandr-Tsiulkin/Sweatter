package com.gmail.tsiulkin.alexandr.service.impl;

import com.gmail.tsiulkin.alexandr.repository.UserRepository;
import com.gmail.tsiulkin.alexandr.repository.model.Role;
import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.UserService;
import com.gmail.tsiulkin.alexandr.service.converter.UserConverter;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.RoleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public boolean save(AddUserDTO addUserDTO) {
        User userByUsername = userRepository.findByUsername(addUserDTO.getUsername());
        if (Objects.isNull(userByUsername)) {
            User user = userConverter.convert(addUserDTO);
            String encodePassword = passwordEncoder.encode(addUserDTO.getPassword());
            user.setPassword(encodePassword);
            user.setActive(true);
            Role role = new Role();
            role.setUser(user);
            role.setRoleName(RoleEnum.USER.name());
            user.setRoles(Collections.singleton(role));
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
