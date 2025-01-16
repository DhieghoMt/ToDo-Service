package com.todolist.app.config;

import com.todolist.app.service.interfaces.ICategoryService;
import com.todolist.app.service.interfaces.ITaskService;
import com.todolist.app.service.interfaces.IUserService;
import com.todolist.app.usecase.CategoryUseCase;
import com.todolist.app.usecase.TaskUseCase;
import com.todolist.app.usecase.UserUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public TaskUseCase taskUseCase(ITaskService service, ICategoryService categoryService) {
        return new TaskUseCase(service, categoryService);
    }

    @Bean
    public UserUsecase userUsecase(IUserService service) {
        return new UserUsecase(service);
    }

    @Bean
    public CategoryUseCase categoryUseCase(ICategoryService service) {
        return new CategoryUseCase(service);
    }
}
