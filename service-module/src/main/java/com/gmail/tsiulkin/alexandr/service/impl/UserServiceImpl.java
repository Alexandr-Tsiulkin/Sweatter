package com.gmail.tsiulkin.alexandr.service.impl;

import com.gmail.tsiulkin.alexandr.repository.RoleRepository;
import com.gmail.tsiulkin.alexandr.repository.UserRepository;
import com.gmail.tsiulkin.alexandr.repository.model.Role;
import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.UserService;
import com.gmail.tsiulkin.alexandr.service.converter.UserConverter;
import com.gmail.tsiulkin.alexandr.service.exception.UserAlreadyExistsException;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.EditUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.RoleEnum;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public ShowUserDTO save(AddUserDTO addUserDTO) throws UserAlreadyExistsException {
        User userByUsername = userRepository.findByUsername(addUserDTO.getUsername());
        if (Objects.isNull(userByUsername)) {
            User user = userConverter.convert(addUserDTO);
            String encodePassword = passwordEncoder.encode(addUserDTO.getPassword());
            user.setPassword(encodePassword);
            user.setActive(false);
            user.setActivatedCode(UUID.randomUUID().toString());
            Role role = roleRepository.findByRoleName(RoleEnum.USER.name());
            user.getRoles().add(role);
            role.getUsers().add(user);
            userRepository.save(user);
            return userConverter.convert(user);
        } else {
            throw new UserAlreadyExistsException(String.format("User with username: %s already exists", addUserDTO.getUsername()));
        }
    }

    @Override
    @Transactional
    public List<ShowUserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(userConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean edit(EditUserDTO editUser) {
        Optional<User> userById = userRepository.findById(editUser.getId());
        if (userById.isPresent()) {
            User user = userById.get();
            user.setUsername(editUser.getUsername());
            if (!editUser.getRoleNames().isEmpty()) {
                user.getRoles().clear();
                for (String roleName : editUser.getRoleNames()) {
                    Role role = roleRepository.findByRoleName(roleName);
                    if (Objects.nonNull(role)) {
                        user.getRoles().add(role);
                        role.getUsers().add(user);
                    }
                }
            }
        }
        return true;
    }

    @Override
    @Transactional
    public boolean isDeleted(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    @Transactional
    public boolean activateUser(String code) {
        User user = userRepository.findByActivatedCode(code);
        if (Objects.nonNull(user)) {
            user.setActivatedCode(null);
            user.setActive(true);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
