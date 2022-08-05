package com.example.rentcar.controller;

import com.example.rentcar.model.CarsDto;
import com.example.rentcar.model.InformationDto;
import com.example.rentcar.service.CarsService;
import com.example.rentcar.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class PricingController {
    CarsService carsService;
    InformationService informationService;


    @GetMapping("/pricing")
    public String getPricing(Model model) {
        List<CarsDto> carsDtoList = carsService.getCarsList();
        model.addAttribute("cars", carsDtoList);

        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "pricing";
    }
}
