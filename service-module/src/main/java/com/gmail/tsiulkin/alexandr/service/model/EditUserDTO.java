package com.gmail.tsiulkin.alexandr.service.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class EditUserDTO {

    private Long id;
    private String username;
    private Set<String> roleNames = new HashSet<>();
}
