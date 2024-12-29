package com.todolist.app.util;

import com.todolist.app.model.dto.task.TaskDto;
import com.todolist.app.model.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {


//    public static TaskEntity convertToEntity(TaskAddDto taskAddDto) {
//        return TaskEntity.builder()
//                .title(taskAddDto.getTitle())
//                .description(taskAddDto.getDescription())
//                .status(taskAddDto.getStatus())
//                .due_date(taskAddDto.getDue_date())
//                .updated_At(taskAddDto.getUpdated_At())
//
//                .build();
//
//    }

    public static TaskDto convertToDto(TaskEntity taskEntity) {
        return TaskDto.builder()
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .status(taskEntity.getStatus())
                .due_date(taskEntity.getDue_date())
                .updated_At(taskEntity.getUpdated_At())
                .userId(taskEntity.getUser().getUserId())
                .build();

    }
}
