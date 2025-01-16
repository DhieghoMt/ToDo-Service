package com.todolist.app.service.interfaces;

import com.todolist.app.model.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {

    List<CategoryEntity> listAllCategories();

    CategoryEntity getCategoryById(String id);

    CategoryEntity saveCategory(CategoryEntity entity);

    CategoryEntity updateCategory(CategoryEntity entity);

    void deleteCategory(String id);
}
