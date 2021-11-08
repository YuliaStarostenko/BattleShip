package com.example.examspringfundaments.repository;

import com.example.examspringfundaments.models.entity.Ship;
import com.example.examspringfundaments.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

List<Ship> findShipsByUser(User user);

}
