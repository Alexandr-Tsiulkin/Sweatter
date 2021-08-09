package com.gmail.tsiulkin.alexandr.service.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.gmail.tsiulkin.alexandr.service.constant.UserValidationConstant.MAXIMUM_PASSWORD_CHARS;
import static com.gmail.tsiulkin.alexandr.service.constant.UserValidationConstant.MAXIMUM_USERNAME_CHARS;

@Data
public class AddUserDTO {

    @NotBlank
    @NotNull
    @Email
    @Size(max = MAXIMUM_USERNAME_CHARS, message = "The Username can contain from 1 to 50 characters.")
    private String username;
    @NotBlank
    @NotNull
    @Size(max = MAXIMUM_PASSWORD_CHARS, message = "The Password can contain from 1 to 60 characters.")
    private String password;
}
