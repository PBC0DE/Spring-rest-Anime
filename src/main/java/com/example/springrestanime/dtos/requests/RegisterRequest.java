package com.example.springrestanime.dtos.requests;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterRequest {

    @NotBlank
    private final String username;

    @Size(min = 6, max = 30)
    private final String password;

}
