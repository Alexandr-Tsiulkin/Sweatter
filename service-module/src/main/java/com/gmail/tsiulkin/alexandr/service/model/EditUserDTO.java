package com.gmail.tsiulkin.alexandr.service.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static com.gmail.tsiulkin.alexandr.service.constant.UserValidationConstant.MAXIMUM_USERNAME_CHARS;

@Data
public class EditUserDTO {

    private Long id;
    @NotBlank
    @NotNull
    @Email
    @Size(max = MAXIMUM_USERNAME_CHARS, message = "The Username can contain from 1 to 50 characters.")
    private String username;
    private Set<String> roleNames = new HashSet<>();
}
