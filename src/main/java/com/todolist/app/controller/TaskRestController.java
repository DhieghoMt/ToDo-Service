package com.todolist.app.controller;

import com.todolist.app.model.dto.TaskDto;
import com.todolist.app.usecase.TaskUseCase;
import com.todolist.app.util.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.todolist.app.util.Constants.SUCCESS;
import static com.todolist.app.util.ServerResponse.responseWith200;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskRestController {

    private final TaskUseCase useCase;

    @GetMapping
    public ResponseEntity<ServerResponse<List<TaskDto>>> listAllTasks(HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.listAllTasks());
    }

    @GetMapping(path = "/{taskId}")
    public ResponseEntity<ServerResponse<TaskDto>> getTaskById(@PathVariable(name = "taskId") String taskId, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.getTaskById(taskId));
    }

    @PostMapping
    public ResponseEntity<ServerResponse<TaskDto>> saveTask(@Valid @RequestBody TaskDto taskAddDto, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.saveTask(taskAddDto));
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<ServerResponse<TaskDto>> updateTask(@Valid @RequestBody TaskDto taskDto, @PathVariable(name = "taskId") String taskId, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.updateTask(taskDto, taskId));
    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<ServerResponse<String>> deleteTask(@PathVariable(name = "taskId") String taskId, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.deleteTask(taskId));
    }


}