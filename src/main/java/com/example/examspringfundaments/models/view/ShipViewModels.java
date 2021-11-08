package com.example.examspringfundaments.models.view;

public class ShipViewModels {

    private Long id;
    private String name;
    private Long health;
    private Long power;

    public ShipViewModels() {
    }

    public ShipViewModels(Long id,String name, Long health, Long power) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.id=id;
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
}
