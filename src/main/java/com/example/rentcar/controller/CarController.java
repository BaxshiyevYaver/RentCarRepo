package com.example.rentcar.controller;

import com.example.rentcar.model.BlogCommentsDto;
import com.example.rentcar.model.CarCommentsDto;
import com.example.rentcar.model.CarsDto;
import com.example.rentcar.model.InformationDto;
import com.example.rentcar.service.CarCommentsService;
import com.example.rentcar.service.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class CarController {
    CarsService carsService;
    CarCommentsService carCommentsService;


    @GetMapping("/car")
    public String getCar(Model model) {
        List<CarsDto> carsDtoList = carsService.getCarsList();
        model.addAttribute("cars", carsDtoList);
        return "car";
    }

    @GetMapping("/car-single")
    public String getCarSingle(Model model) {
        List<CarsDto> carsDtoList = carsService.getCarsList();
        model.addAttribute("cars", carsDtoList);
        List<CarCommentsDto> carCommentsDtoList = carCommentsService.getCarCommentsList();
        model.addAttribute("carComments", carCommentsDtoList);
        return "car-single";
    }

    @PostMapping("/saveCarComments")
    public String saveCarComments(CarCommentsDto carCommentsDto) {
        LocalDate time = LocalDate.now();
        carCommentsDto.setDate(Date.valueOf(time));

        carCommentsService.saveCarComments(carCommentsDto);
        return "redirect:/rentCar/car-single/";

    }

}
