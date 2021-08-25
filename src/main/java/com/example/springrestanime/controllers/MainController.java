package com.example.springrestanime.controllers;

import com.example.springrestanime.dtos.UserDTO;
import com.example.springrestanime.dtos.requests.RegisterRequest;
import com.example.springrestanime.dtos.responses.LoginResponse;
import com.example.springrestanime.entities.User;
import com.example.springrestanime.services.JwtService;
import com.example.springrestanime.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    private final JwtService jwtService;

    private final UserService userService;

    public MainController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "OK";
    }

    @GetMapping("/http")
    public ResponseEntity<Integer> http(@RequestParam("status") Integer status) {
        return new ResponseEntity<>(status, HttpStatus.valueOf(status));
    }

    @PostMapping("/login")
    public LoginResponse login(@AuthenticationPrincipal User user) {
        return new LoginResponse(jwtService.createToken(user), new UserDTO(user));
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@AuthenticationPrincipal User user, @Valid @RequestBody RegisterRequest registerRequest) {
        return new UserDTO(userService.createUser(new User(registerRequest)));

    }
}
