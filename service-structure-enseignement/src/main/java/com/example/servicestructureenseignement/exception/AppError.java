package com.example.servicestructureenseignement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
public class AppError {

    private String message;
    private HttpStatus status;
    private LocalDateTime timeStamp;
}
