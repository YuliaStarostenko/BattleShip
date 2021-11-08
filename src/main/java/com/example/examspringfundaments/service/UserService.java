package com.example.examspringfundaments.service;

import com.example.examspringfundaments.models.entity.User;
import com.example.examspringfundaments.models.service.UserServiceModel;
import com.example.examspringfundaments.models.view.ShipViewModels;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

}
