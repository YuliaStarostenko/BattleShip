package com.example.examspringfundaments.service.impl;

import com.example.examspringfundaments.models.entity.Category;
import com.example.examspringfundaments.models.enums.CategoryNameEnum;
import com.example.examspringfundaments.repository.CategoryRepository;
import com.example.examspringfundaments.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category
                                = new Category(categoryNameEnum);
                        categoryRepository.save(category);
                    });

        }
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
