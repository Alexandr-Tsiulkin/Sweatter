package com.gmail.tsiulkin.alexandr.service;

import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.exception.NotFoundException;
import com.gmail.tsiulkin.alexandr.service.exception.UserAlreadyExistsException;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.EditUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.UpdateUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.UserLogin;

import java.util.List;

public interface UserService {

    ShowUserDTO save(AddUserDTO user) throws UserAlreadyExistsException;

    List<ShowUserDTO> getAllUsers();

    boolean edit(EditUserDTO user);

    boolean isDeleted(User user);

    boolean activateUser(String code);

    ShowUserDTO updateUser(UserLogin user, UpdateUserDTO updateUser) throws NotFoundException;
}
