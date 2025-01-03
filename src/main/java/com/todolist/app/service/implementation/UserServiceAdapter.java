package com.todolist.app.service.implementation;

import com.todolist.app.exceptions.TaskException;
import com.todolist.app.exceptions.UserException;
import com.todolist.app.model.entity.UserEntity;
import com.todolist.app.repository.UserRepository;
import com.todolist.app.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.todolist.app.util.Constants.*;

@Service
@AllArgsConstructor
public class UserServiceAdapter implements IUserService {

    private final UserRepository repository;

    @Override
    public List<UserEntity> listAllUsers() {
        if (repository.findAll().isEmpty()) {
            throw new UserException(USER_NOT_FOUND, 200, List.of());
        }
        return repository.findAll();
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return repository.save(userEntity);
    }
}
