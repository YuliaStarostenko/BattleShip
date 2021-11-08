package com.example.examspringfundaments.web;

import com.example.examspringfundaments.models.binding.ShipAddBindingModel;
import com.example.examspringfundaments.models.service.ShipServiceModel;
import com.example.examspringfundaments.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;


    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(){
        return "ship-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);

            return "redirect:add";

        }

        shipService
                .addOrder(modelMapper
                        .map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/";

    }

    @PostMapping("/fire")
    public String fire(@RequestParam("myShipId") Long myShipId, @RequestParam("otherShipId") Long otherShipId){

        shipService.fire(myShipId, otherShipId);

        return "redirect:/";
    }


    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }
}
