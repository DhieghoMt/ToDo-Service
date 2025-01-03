package com.todolist.app.usecase;

import com.todolist.app.model.dto.TaskDto;
import com.todolist.app.model.entity.TaskEntity;
import com.todolist.app.service.interfaces.ITaskService;
import com.todolist.app.util.TaskMapper;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.todolist.app.util.TaskMapper.convertToDto;
import static com.todolist.app.util.TaskMapper.convertToEntity;

@AllArgsConstructor
public class TaskUseCase {

    private final ITaskService service;


    public List<TaskDto> listAllTasks() {
        return service.listAllTask()
                .stream()
                .map(TaskMapper::convertToDto)
                .toList();
    }

    public TaskDto getTaskById(String taskId) {
        return convertToDto(service.getTaskById(taskId));
    }

    public TaskDto saveTask(TaskDto taskDto) {
        return convertToDto(service.addTask(convertToEntity(taskDto)));
    }

    public TaskDto updateTask(TaskDto taskDto, String taskId) {
        TaskEntity taskExisted = service.getTaskById(taskId);
        taskExisted.setTitle(taskDto.getTitle());
        taskExisted.setDescription(taskDto.getDescription());
        taskExisted.setStatus(taskDto.getStatus());
        taskExisted.setDue_date(taskDto.getDue_date());
        return convertToDto(service.updateTask(taskExisted));
    }


    public String deleteTask(String taskId) {
        service.deleteTask(taskId);
        return "Task removed successfully";
    }


}
