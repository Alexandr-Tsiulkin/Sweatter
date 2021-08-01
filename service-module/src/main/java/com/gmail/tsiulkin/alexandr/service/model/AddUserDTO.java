package com.gmail.tsiulkin.alexandr.service.model;

import lombok.Data;

@Data
public class AddUserDTO {

    private String username;
    private String password;
    private Boolean active;

}
