package com.gmail.tsiulkin.alexandr.service.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ShowUserDTO {

    private Long id;
    private String username;
    private Set<String> roles = new HashSet<>();
}
