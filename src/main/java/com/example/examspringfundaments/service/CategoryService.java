package com.example.examspringfundaments.service;

import com.example.examspringfundaments.models.entity.Category;
import com.example.examspringfundaments.models.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
