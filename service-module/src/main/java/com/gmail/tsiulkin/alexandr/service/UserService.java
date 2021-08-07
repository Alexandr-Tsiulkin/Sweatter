package com.gmail.tsiulkin.alexandr.service;

import com.gmail.tsiulkin.alexandr.service.exception.UserAlreadyExistsException;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.EditUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;

import java.util.List;

public interface UserService {

    ShowUserDTO save(AddUserDTO user) throws UserAlreadyExistsException;

    List<ShowUserDTO> getAllUsers();

    boolean edit(EditUserDTO user);
}
