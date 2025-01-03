package com.todolist.app.service.implementation;

import com.todolist.app.exceptions.UserException;
import com.todolist.app.model.entity.UserEntity;
import com.todolist.app.repository.UserRepository;
import com.todolist.app.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public UserEntity getUserById(String id) {
        if (repository.findById(id).isEmpty()) {
            throw new UserException(USER_NOT_FOUND, 400, null);
        }
        return repository.findById(id).get();
    }

    @Override
    public UserEntity saveUser(UserEntity entity) {
        return Optional.of(repository.save(entity))
                .orElseThrow(() -> new UserException(USER_FAILED_CREATE, 400, null));
    }

    @Override
    public UserEntity updateUser(UserEntity entity) {
        return Optional.of(repository.save(entity))
                .orElseThrow(() -> new UserException(USER_FAILED_UPDATE, 400, null));
    }


    @Override
    public void deleteUser(String id) {
        if (repository.findById(id).isEmpty()) {
            throw new UserException(USER_NOT_FOUND, 400, null);
        }
        repository.deleteById(id);
    }
}
