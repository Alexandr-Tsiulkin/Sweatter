package com.gmail.tsiulkin.alexandr.service;

import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.EditUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowMessageDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;

import java.util.List;

public interface UserService {

    boolean save(AddUserDTO user);

    List<ShowUserDTO> getAllUsers();

    boolean edit(EditUserDTO user);
}
