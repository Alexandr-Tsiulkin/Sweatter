package com.gmail.tsiulkin.alexandr.service;

import com.gmail.tsiulkin.alexandr.service.model.AddUserDTO;

public interface UserService {

    boolean save(AddUserDTO user);
}
