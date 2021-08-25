package com.example.springrestanime.dtos.responses;

import com.example.springrestanime.dtos.UserDTO;
import lombok.Data;

@Data
public class LoginResponse {

    private final String accessToken;

    private final UserDTO user;
}
