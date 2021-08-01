package com.gmail.tsiulkin.alexandr.service.model;

import com.gmail.tsiulkin.alexandr.repository.model.User;
import lombok.Data;

@Data
public class ShowMessageDTO {

    private Long id;
    private String text;
    private String tag;
    private User author;
}
