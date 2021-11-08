package com.example.examspringfundaments.repository;

import com.example.examspringfundaments.models.entity.User;
import com.example.examspringfundaments.models.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);
}
