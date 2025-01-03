package com.todolist.app.util;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public record ServerResponse<T>(String message,
                                @JsonFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime timestamp,
                                String path,
                                T data) {

    public static <T> ResponseEntity<ServerResponse<T>> responseWith200(String message, String requestUri, T data) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ServerResponse<T>(message, LocalDateTime.now(), requestUri, data));
    }

    public static <T> ResponseEntity<ServerResponse<T>> responseWith400(String message, String requestUri, T data) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ServerResponse<T>(message, LocalDateTime.now(), requestUri, data));
    }

    public static <T> ResponseEntity<ServerResponse<T>> responseWith500(String message, String requestUri, T data) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ServerResponse<T>(message, LocalDateTime.now(), requestUri, data));
    }

    public static <T> ResponseEntity<ServerResponse<T>> responseCustom(int code, String message, String requestUri, T data) {
        return ResponseEntity.status(HttpStatus.valueOf(code))
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ServerResponse<T>(message, LocalDateTime.now(), requestUri, data));
    }


}
