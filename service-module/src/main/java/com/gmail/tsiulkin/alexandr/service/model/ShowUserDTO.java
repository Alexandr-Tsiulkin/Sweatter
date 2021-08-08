package com.gmail.tsiulkin.alexandr.service.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class ShowUserDTO {

    private Long id;
    private String username;
    private String activationCode;
    private Set<String> roles = new HashSet<>();
}
