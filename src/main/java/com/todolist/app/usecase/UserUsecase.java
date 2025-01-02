package com.todolist.app.usecase;

import com.todolist.app.model.dto.user.UserDto;
import com.todolist.app.model.entity.UserEntity;
import com.todolist.app.service.interfaces.IUserService;
import com.todolist.app.util.UserMapper;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.todolist.app.util.UserMapper.convertToEntity;

@AllArgsConstructor
public class UserUsecase {

    private final IUserService service;

    public List<UserDto> listAllUsers() {
        return service.listAllUsers()
                .stream()
                .map(UserMapper::convertToDto)
                .toList();
    }

    public UserDto saveUser(UserDto userDto) {
        return UserMapper.convertToDto(service.saveUser(convertToEntity(userDto)));
    }
}
