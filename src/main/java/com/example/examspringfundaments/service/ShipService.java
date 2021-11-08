package com.example.examspringfundaments.service;

import com.example.examspringfundaments.models.service.ShipServiceModel;
import com.example.examspringfundaments.models.view.ShipViewModels;

import java.util.List;

public interface ShipService {
    void addOrder(ShipServiceModel shipServiceModel);

    List<ShipViewModels> findAllShipsOrderbyIDAndHealthAndPower();


    List<ShipViewModels> findAllShipsOfTheCurrentUser(Long id);

    List<ShipViewModels> findAllShipsOwnedByOtherUsers();


    void fire(Long myShipId, Long otherShipId);
}
