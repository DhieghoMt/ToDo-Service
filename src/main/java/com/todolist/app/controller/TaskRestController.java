package com.todolist.app.controller;

import com.todolist.app.model.dto.task.TaskDto;
import com.todolist.app.usecase.TaskUseCase;
import com.todolist.app.util.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
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

//    @PostMapping
//    public ResponseEntity<ServerResponse<TaskDto>> saveTask(@RequestBody TaskAddDto taskAddDto, HttpServletRequest request) {
//        return responseWith200(SUCCESS, request.getRequestURI(), useCase.saveTask(taskAddDto));
//    }

}
