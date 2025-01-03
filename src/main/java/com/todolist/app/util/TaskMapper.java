package com.todolist.app.util;

import com.todolist.app.model.dto.TaskDto;
import com.todolist.app.model.entity.TaskEntity;
import com.todolist.app.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public static TaskDto convertToDto(TaskEntity taskEntity) {
        return TaskDto.builder()
                .taskId(taskEntity.getTaskId())
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .status(taskEntity.getStatus())
                .created_At(taskEntity.getCreated_At())
                .due_date(taskEntity.getDue_date())
                .updated_At(taskEntity.getUpdated_At())
                .userId(taskEntity.getUser().getUserId())
                .build();
    }


    public static TaskEntity convertToEntity(TaskDto taskDto) {
        return TaskEntity.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(taskDto.getStatus())
                .due_date(taskDto.getDue_date())
                .user(UserEntity.builder().userId(taskDto.getUserId()).build())
                .build();

    }


}
