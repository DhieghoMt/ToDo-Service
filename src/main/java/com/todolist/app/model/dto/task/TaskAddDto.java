package com.todolist.app.model.dto.task;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TaskAddDto {

    private String title;
    private String description;
    private String status;
    private LocalDate due_date;
    private String userId;
}
