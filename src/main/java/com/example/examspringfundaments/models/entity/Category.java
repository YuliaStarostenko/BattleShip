package com.example.examspringfundaments.models.entity;

import com.example.examspringfundaments.models.enums.CategoryNameEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    private CategoryNameEnum name;
    private String description;

    public Category(CategoryNameEnum categoryNameEnum) {
        this.name = categoryNameEnum;
    }

    public Category() {

    }

    @Enumerated(EnumType.STRING)
    @NotNull
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
