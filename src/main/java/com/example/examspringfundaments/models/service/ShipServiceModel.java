package com.example.examspringfundaments.models.service;

import com.example.examspringfundaments.models.entity.Category;
import com.example.examspringfundaments.models.entity.User;
import com.example.examspringfundaments.models.enums.CategoryNameEnum;

import java.time.LocalDate;

public class ShipServiceModel {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryNameEnum category;
    private User user;

    public ShipServiceModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
