package com.todolist.app.usecase;

import com.todolist.app.model.dto.UserDto;
import com.todolist.app.model.entity.UserEntity;
import com.todolist.app.service.interfaces.IUserService;
import com.todolist.app.util.UserMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.todolist.app.util.UserMapper.convertToDto;
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

    public UserDto getUserById(String userId) {
        return convertToDto(service.getUserById(userId));
    }

    public UserDto saveUser(UserDto userDto) {
        return convertToDto(service.saveUser(convertToEntity(userDto)));
    }


    public UserDto updateUser(@Valid UserDto userDto, String userId) {
        UserEntity userExisted = service.getUserById(userId);
        userExisted.setUsername(userDto.getUsername());
        userExisted.setPassword(userDto.getPassword());
        userExisted.setEmail(userDto.getEmail());
        userExisted.setRole(userDto.getRole());
        return convertToDto(service.updateUser(userExisted));
    }

    public String deleteTask(String userId) {
        service.deleteUser(userId);
        return "User removed successfully";
    }
}
