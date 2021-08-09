package com.gmail.tsiulkin.alexandr.service.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.gmail.tsiulkin.alexandr.service.constant.MessageValidationConstant.MAXIMUM_TAG_CHARS;
import static com.gmail.tsiulkin.alexandr.service.constant.MessageValidationConstant.MAXIMUM_TEXT_CHARS;

@Data
public class AddMessageDTO {

    @NotBlank
    @NotNull
    @Size(max = MAXIMUM_TEXT_CHARS, message = "The text can contain from 1 to 200 characters.")
    private String text;
    @NotBlank
    @NotNull
    @Size(max = MAXIMUM_TAG_CHARS, message = "The text can contain from 1 to 20 characters.")
    private String tag;
}
