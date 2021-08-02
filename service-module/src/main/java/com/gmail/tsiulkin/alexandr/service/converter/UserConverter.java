package com.gmail.tsiulkin.alexandr.service.converter;

import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;
import com.gmail.tsiulkin.alexandr.service.model.ShowUserDTO;

public interface UserConverter {

    User convert (AddUserDTO addUserDTO);

    ShowUserDTO convert (User user);
}
