package com.todolist.app.service.interfaces;

import com.todolist.app.model.entity.UserEntity;

import java.util.List;

public interface IUserService {
    
    List<UserEntity> listAllUsers();
}
