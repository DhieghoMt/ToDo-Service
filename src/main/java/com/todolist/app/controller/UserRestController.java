package com.todolist.app.controller;

import com.todolist.app.model.dto.UserDto;
import com.todolist.app.usecase.UserUsecase;
import com.todolist.app.util.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.todolist.app.util.Constants.SUCCESS;
import static com.todolist.app.util.ServerResponse.responseWith200;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    private final UserUsecase useCase;

    @GetMapping
    public ResponseEntity<ServerResponse<List<UserDto>>> listAllUsers(HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.listAllUsers());
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<ServerResponse<UserDto>> getUserById(@PathVariable(name = "userId") String userId, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.getUserById(userId));
    }

    @PostMapping
    public ResponseEntity<ServerResponse<UserDto>> saveUser(@RequestBody UserDto userDto, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.saveUser(userDto));
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<ServerResponse<UserDto>> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable(name = "userId") String userId, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.updateUser(userDto, userId));
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<ServerResponse<String>> deleteUser(@PathVariable(name = "userId") String userId, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.deleteTask(userId));
    }
}
