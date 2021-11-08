package com.example.examspringfundaments.web;

import com.example.examspringfundaments.models.view.ShipViewModels;
import com.example.examspringfundaments.service.ShipService;
import com.example.examspringfundaments.service.UserService;
import com.example.examspringfundaments.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ShipService shipService, UserService userService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){
        if (currentUser.getId() == null){
            return "index";
        }

        List<ShipViewModels> ships = shipService.findAllShipsOrderbyIDAndHealthAndPower();

        model.addAttribute("ships", ships);

        List<ShipViewModels> userShips =
                shipService.findAllShipsOfTheCurrentUser(currentUser.getId());

        model.addAttribute("userShips", userShips);

        List<ShipViewModels> otherShips = shipService.findAllShipsOwnedByOtherUsers();

        model.addAttribute("otherShips", otherShips);



        return "home";
    }

}
