package com.todolist.app.usecase;

import com.todolist.app.model.entity.UserEntity;
import com.todolist.app.service.interfaces.IUserService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserUsecase {

    private final IUserService service;

    public List<UserEntity> listAllUsers() {
        return service.listAllUsers();
    }

//    public TaskAddDto saveTask(TaskAddDto taskAddDto) {
//
//        TaskEntity taskEntity = taskMapperConvertToEntity(taskAddDto);
//        return taskMapperConvertToDto(service.addTask(taskEntity));
//    }
}
