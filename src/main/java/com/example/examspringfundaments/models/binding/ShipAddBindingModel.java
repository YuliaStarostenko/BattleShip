package com.example.examspringfundaments.models.binding;

import com.example.examspringfundaments.models.entity.Category;
import com.example.examspringfundaments.models.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddBindingModel {

    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }


    @Size(min = 2, max = 10)
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Positive
    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }


    @Positive
    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }


    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @NotNull
    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }
}
