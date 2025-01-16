package com.todolist.app.service.implementation;

import com.todolist.app.exceptions.TaskException;
import com.todolist.app.model.entity.CategoryEntity;
import com.todolist.app.model.entity.TaskEntity;
import com.todolist.app.repository.TaskRepository;
import com.todolist.app.service.interfaces.ITaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.todolist.app.util.Constants.*;

@Service
@AllArgsConstructor
public class TaskServiceAdapter implements ITaskService {

    private final TaskRepository repository;

    @Override
    public List<TaskEntity> listAllTask() {
        if (repository.findAll().isEmpty()) {
            throw new TaskException(TASK_NOT_FOUND, 200, List.of());
        }
        return repository.findAll();
    }

    @Override
    public TaskEntity getTaskById(String id) {
        if (repository.findById(id).isEmpty()) {
            throw new TaskException(TASK_NOT_FOUND, 400, null);
        }
        return repository.findById(id).get();
    }

    @Override
    public TaskEntity addTask(TaskEntity entity) {
        return Optional.of(repository.save(entity))
                .orElseThrow(() -> new TaskException(TASK_FAILED_CREATE, 400, null));

    }

    @Override
    public TaskEntity updateTask(TaskEntity entity) {
        return Optional.of(repository.save(entity))
                .orElseThrow(() -> new TaskException(TASK_FAILED_UPDATE, 400, null));
    }

    @Override
    public void deleteTask(String id) {
        if (repository.findById(id).isEmpty()) {
            throw new TaskException(TASK_NOT_FOUND, 400, null);
        }
        repository.deleteById(id);
    }

    @Override
    public List<TaskEntity> getTasksByUserId(String userId) {
        if (repository.getTasksByUserId(userId).isEmpty()) {
            throw new TaskException(TASK_NOT_FOUND, 200, List.of());
        }
        return repository.getTasksByUserId(userId);
    }

    @Override
    public TaskEntity asignTaskToCategory(TaskEntity task, CategoryEntity category) {
        List<CategoryEntity> categories = Optional.ofNullable(task.getCategories()).orElseGet(ArrayList::new);
        if (categories.contains(category)) {
            throw new TaskException(TASK_CATEGORY_ALREADY_ASIGNNED, 400, null);
        }
        categories.add(category);
        task.setCategories(categories);
        task.setStatus("ASSIGNED");
        return Optional.of(task)
                .map(repository::save)
                .orElseThrow(() -> new TaskException(TASK_FAILED_CREATE, 400, null));

    }


}
