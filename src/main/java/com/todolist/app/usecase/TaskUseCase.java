package com.todolist.app.usecase;

import com.todolist.app.model.dto.task.TaskDto;
import com.todolist.app.model.entity.TaskEntity;
import com.todolist.app.service.interfaces.ITaskService;
import com.todolist.app.util.TaskMapper;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class TaskUseCase {

    private final ITaskService service;


    public List<TaskDto> listAllTasks() {
        return service.listAllTask()
                .stream()
                .map(TaskMapper::convertToDto)
                .toList();
    }

//    public TaskDto saveTask(TaskAddDto taskAddDto) {
//
//        TaskEntity taskEntity = convertToEntity(taskAddDto);
//        return convertToDto(service.addTask(taskEntity));
//    }


}
