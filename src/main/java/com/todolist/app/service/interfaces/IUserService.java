package com.todolist.app.service.interfaces;

import com.todolist.app.model.entity.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> listAllUsers();

    UserEntity saveUser(UserEntity entity);

    UserEntity updateUser(UserEntity entity);

    UserEntity getUserById(String id);

    void deleteUser(String id);
}
