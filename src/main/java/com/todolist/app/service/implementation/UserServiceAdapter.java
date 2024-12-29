package com.todolist.app.service.implementation;

import com.todolist.app.model.entity.UserEntity;
import com.todolist.app.repository.UserRepository;
import com.todolist.app.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceAdapter implements IUserService {

    private final UserRepository repository;

    @Override
    public List<UserEntity> listAllUsers() {
        return repository.findAll();
    }
}
