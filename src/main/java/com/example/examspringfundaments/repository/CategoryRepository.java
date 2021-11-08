package com.example.examspringfundaments.repository;

import com.example.examspringfundaments.models.entity.Category;
import com.example.examspringfundaments.models.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryNameEnum name);
}
