package com.gmail.tsiulkin.alexandr.service.converter.impl;

import com.gmail.tsiulkin.alexandr.repository.model.Role;
import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.converter.UserConverter;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User convert(AddUserDTO addUserDTO) {
        User user = new User();
        user.setUsername(addUserDTO.getUsername());
        return user;
    }

    @Override
    public ShowUserDTO convert(User user) {
        ShowUserDTO showUserDTO = new ShowUserDTO();
        showUserDTO.setId(user.getId());
        showUserDTO.setUsername(user.getUsername());
        Set<Role> roles = user.getRoles();
        if (!roles.isEmpty()) {
            for (Role role : roles) {
                String roleName = role.getRoleName();
                showUserDTO.getRoles().add(roleName);
            }
        }
        return showUserDTO;
    }
}
