package com.example.springrestanime.dtos.responses;

import lombok.Data;

@Data
public class ErrorResponse {

    private final int status;

    private final String message;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
