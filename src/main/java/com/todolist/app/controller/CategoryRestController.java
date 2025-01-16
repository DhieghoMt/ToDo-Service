package com.todolist.app.controller;

import com.todolist.app.model.dto.CategoryDto;
import com.todolist.app.usecase.CategoryUseCase;
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
@RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryRestController {

    private final CategoryUseCase useCase;

    @GetMapping
    public ResponseEntity<ServerResponse<List<CategoryDto>>> listAllCategories(HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.listAllCategories());
    }

    @PostMapping
    public ResponseEntity<ServerResponse<CategoryDto>> saveCategory(@Valid @RequestBody CategoryDto categoryDto, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.saveCategory(categoryDto));
    }

    @PutMapping(path = "/{categoryId}")
    public ResponseEntity<ServerResponse<CategoryDto>> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable(name = "categoryId") String categoryId, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.updateCategory(categoryDto, categoryId));
    }

    @DeleteMapping(path = "/{categoryId}")
    public ResponseEntity<ServerResponse<String>> deleteCategory(@PathVariable(name = "categoryId") String categoryId, HttpServletRequest request) {
        return responseWith200(SUCCESS, request.getRequestURI(), useCase.deleteCategory(categoryId));
    }


}
