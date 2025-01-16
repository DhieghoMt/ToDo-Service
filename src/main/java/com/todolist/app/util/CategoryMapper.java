package com.todolist.app.util;

import com.todolist.app.model.dto.CategoryDto;
import com.todolist.app.model.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public static CategoryDto convertToDto(CategoryEntity categoryEntity) {
        return CategoryDto.builder()
                .categoryId(categoryEntity.getCategoryId())
                .nameCategory(categoryEntity.getNameCategory())
                .build();
    }


    public static CategoryEntity convertToEntity(CategoryDto categoryDto) {
        return CategoryEntity.builder()
                .nameCategory(categoryDto.getNameCategory())
                .build();

    }
}
