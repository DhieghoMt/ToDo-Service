package com.todolist.app.exceptions;

import com.todolist.app.util.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

import static com.todolist.app.util.ServerResponse.*;

@Slf4j
@RestControllerAdvice
public class GlobalHandlerException {

    private final String message = "An error occurred, please try again";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServerResponse<Object>> handleGeneralException(Exception e, HttpServletRequest request) {
        log.error("Error: ", e);
        return responseWith500(message, request.getRequestURI(), null);
    }

    @ExceptionHandler(TaskException.class)
    public ResponseEntity<ServerResponse<Object>> handleTaskException(TaskException e, HttpServletRequest request) {
        Object data = e.getData();
        String message = e.getMessage();
        int code = e.getHttpStatusCode();
        String path = request.getRequestURI();
        return responseCustom(code, message, path, data);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServerResponse<Object>> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return responseWith400(message, path, errors);
    }


}
