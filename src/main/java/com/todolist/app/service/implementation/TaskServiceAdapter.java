package com.todolist.app.service.implementation;

import com.todolist.app.model.entity.TaskEntity;
import com.todolist.app.repository.TaskRepository;
import com.todolist.app.service.interfaces.ITaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceAdapter implements ITaskService {

    private final TaskRepository repository;

    @Override
    public List<TaskEntity> listAllTask() {
        return repository.findAll();
    }

    @Override
    public TaskEntity addTask(TaskEntity entity) {
        return repository.save(entity);
    }
}
