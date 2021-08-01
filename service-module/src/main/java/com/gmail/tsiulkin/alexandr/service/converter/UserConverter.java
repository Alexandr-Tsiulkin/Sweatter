package com.gmail.tsiulkin.alexandr.service.converter;

import com.gmail.tsiulkin.alexandr.repository.model.User;
import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;

public interface UserConverter {

    User convert (AddUserDTO addUserDTO);
}
