package com.todolist.app.util;

import com.todolist.app.model.dto.user.UserDto;
import com.todolist.app.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto convertToDto(UserEntity userEntity) {
        return UserDto.builder()
                .userId(userEntity.getUserId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .role(userEntity.getRole())
                .created_At(userEntity.getCreated_At())
                .updated_At(userEntity.getUpdated_At())
                .build();
    }

    public static UserEntity convertToEntity(UserDto userDto) {
        return UserEntity.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .email(userDto.getEmail())
                .build();
    }
}
