package com.example.examspringfundaments.service.impl;

import com.example.examspringfundaments.models.entity.Ship;
import com.example.examspringfundaments.models.entity.User;
import com.example.examspringfundaments.models.service.ShipServiceModel;
import com.example.examspringfundaments.models.view.ShipViewModels;
import com.example.examspringfundaments.repository.ShipRepository;
import com.example.examspringfundaments.service.CategoryService;
import com.example.examspringfundaments.service.ShipService;
import com.example.examspringfundaments.service.UserService;
import com.example.examspringfundaments.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(ShipServiceModel shipServiceModel) {
        Ship ship = modelMapper.map(shipServiceModel, Ship.class);
        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()));
        shipRepository.save(ship);
    }


    @Override
    public List<ShipViewModels> findAllShipsOrderbyIDAndHealthAndPower() {
        return shipRepository.findAll().stream()
                .map(order -> modelMapper.map(order, ShipViewModels.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModels> findAllShipsOfTheCurrentUser(Long id) {
        User theUser = userService.findById(id);
        return shipRepository
                .findShipsByUser(theUser)
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModels.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModels> findAllShipsOwnedByOtherUsers() {

        List<Ship> ships = shipRepository.findAll();
        List<Ship> otherShips = new ArrayList<>();
        for (Ship ship : ships) {
            if (!ship.getUser().getId().equals(currentUser.getId())){
                otherShips.add(ship);
            }
        }
         return otherShips.stream().map(ship -> modelMapper.map(ship, ShipViewModels.class)).collect(Collectors.toList());

    }

    @Override
    public void fire(Long myShipId, Long otherShipId) {
        Ship attacker = shipRepository.findById(myShipId).orElse(null);
        Ship defender = shipRepository.findById(otherShipId).orElse(null);

        assert defender != null;
        assert attacker != null;
        defender.setHealth(defender.getHealth() - attacker.getPower());
        if (defender.getHealth() <= 0){
            shipRepository.deleteById(otherShipId);
        }
        shipRepository.save(defender);
    }


}
