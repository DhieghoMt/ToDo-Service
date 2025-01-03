package com.todolist.app.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto {

    private String taskId;

    @NotBlank(message = "Title is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Title must be alphanumeric")
    private String title;

    @NotBlank(message = "Description is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Description must be alphanumeric")
    private String description;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Status must be alphanumeric")
    private String status;


    private LocalDate created_At;

    @NotNull(message = "Due Date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate due_date;


    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime updated_At;


    @NotBlank(message = "User Id is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "User Id must be alphanumeric")
    private String userId;
}
