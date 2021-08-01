package com.gmail.tsiulkin.alexandr.service.converter.impl;

import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.converter.UserConverter;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User convert(AddUserDTO addUserDTO) {
        User user = new User();
        user.setUsername(addUserDTO.getUsername());
        return user;
    }
}
