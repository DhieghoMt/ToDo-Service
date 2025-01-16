package com.todolist.app.usecase;

import com.todolist.app.model.dto.CategoryDto;
import com.todolist.app.model.entity.CategoryEntity;
import com.todolist.app.service.interfaces.ICategoryService;
import com.todolist.app.util.CategoryMapper;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.todolist.app.util.CategoryMapper.convertToDto;
import static com.todolist.app.util.CategoryMapper.convertToEntity;


@AllArgsConstructor
public class CategoryUseCase {

    private final ICategoryService service;

    public List<CategoryDto> listAllCategories() {
        return service.listAllCategories()
                .stream()
                .map(CategoryMapper::convertToDto)
                .toList();
    }


    public CategoryDto saveCategory(CategoryDto categoryDto) {
        return convertToDto(service.saveCategory(convertToEntity(categoryDto)));
    }

    public CategoryDto updateCategory(CategoryDto categoryDto, String categoryId) {
        CategoryEntity categoryExisted = service.getCategoryById(categoryId);
        categoryExisted.setNameCategory(categoryDto.getNameCategory());
        return convertToDto(service.updateCategory(categoryExisted));
    }


    public String deleteCategory(String categoryId) {
        service.deleteCategory(categoryId);
        return "Category removed successfully";
    }
}
