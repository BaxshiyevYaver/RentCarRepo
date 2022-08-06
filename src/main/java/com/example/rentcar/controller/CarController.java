package com.example.rentcar.controller;

import com.example.rentcar.model.*;
import com.example.rentcar.service.CarCommentsService;
import com.example.rentcar.service.CarsService;
import com.example.rentcar.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class CarController {
    CarsService carsService;
    CarCommentsService carCommentsService;
    InformationService informationService;


    @GetMapping("/car")
    public String redirectCar(Model model) {
        List<CarsDto> carsDtoList = carsService.getCarsList();
        model.addAttribute("cars", carsDtoList);

        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "car";
    }

    @GetMapping("/car-single/{carId}")
    public String redirectCarSingle(Model model, @PathVariable("carId") Integer carId) {

        CarsDto carsDto = carsService.getCar(carId);
        model.addAttribute("cars", carsDto);

        List<CarCommentsDto> carCommentsDtoList = carCommentsService.getCarCommentsList();
        model.addAttribute("carComments", carCommentsDtoList);

        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "car-single";
    }

    @GetMapping("/addCar")
    public String redirectCarAdd(Model model) {
        return "addCar";
    }

    @PostMapping("/saveCarComments")
    public String saveCarComments(CarCommentsDto carCommentsDto) {
        LocalDate time = LocalDate.now();
        carCommentsDto.setDate(Date.valueOf(time));

        carCommentsService.saveCarComments(carCommentsDto);
        return "redirect:/rentCar/car-single/";

    }

    @GetMapping("/deleteCar/{carId}")
    public String deleteCar(@PathVariable("carId") Integer carId, Model model) {
        carsService.deleteCar(carId);

        return "redirect:/rentCar/admin/";
    }

    @GetMapping("/editCar/{carId}")
    public String editCar(
            @PathVariable("carId") Integer carId,
            Model model) {
        CarsDto carsDto = carsService.getCar(carId);
        model.addAttribute("car", carsDto);
        return "edit_car";
    }

    @PostMapping("/saveCar")
    public String saveCar(CarsDto carsDto) {
        carsService.saveCar(carsDto);
        return "redirect:/rentCar/admin/";
    }

}
