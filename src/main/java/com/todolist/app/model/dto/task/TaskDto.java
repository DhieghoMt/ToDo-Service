package com.todolist.app.model.dto.task;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class TaskDto {

    private String title;
    private String description;
    private String status;
    private Date due_date;
    private LocalDate updated_At;
    private String userId;

}
