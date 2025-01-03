package com.todolist.app.service.interfaces;

import com.todolist.app.model.entity.TaskEntity;

import java.util.List;

public interface ITaskService {

    List<TaskEntity> listAllTask();

    TaskEntity addTask(TaskEntity entity);

    TaskEntity updateTask(TaskEntity entity);

    TaskEntity getTaskById(String id);

    void deleteTask(String id);
}
