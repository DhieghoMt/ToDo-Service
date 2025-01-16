package com.todolist.app.service.implementation;

import com.todolist.app.exceptions.CategoryException;
import com.todolist.app.model.entity.CategoryEntity;
import com.todolist.app.repository.CategoryRepository;
import com.todolist.app.service.interfaces.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.todolist.app.util.Constants.*;

@Service
@AllArgsConstructor
public class CategoryServiceAdapter implements ICategoryService {


    private final CategoryRepository repository;


    @Override
    public List<CategoryEntity> listAllCategories() {
        List<CategoryEntity> data = repository.findAll();
        if (data.isEmpty()) {
            throw new CategoryException(CATEGORY_NOT_FOUND, 400, List.of());
        }
        return data;
    }

    @Override
    public CategoryEntity getCategoryById(String id) {
        Optional<CategoryEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new CategoryException(CATEGORY_NOT_FOUND, 400, null);
        }
        return entity.get();
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity entity) {
        return Optional.of(repository.save(entity))
                .orElseThrow(() -> new CategoryException(CATEGORY_FAILED_CREATE, 400, null));
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity entity) {
        return Optional.of(repository.save(entity))
                .orElseThrow(() -> new CategoryException(CATEGORY_FAILED_UPDATE, 400, null));
    }

    @Override
    public void deleteCategory(String id) {
        if (repository.findById(id).isEmpty()) {
            throw new CategoryException(CATEGORY_NOT_FOUND, 400, null);
        }
        repository.deleteById(id);
    }
}
