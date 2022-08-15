package com.example.rentcar.controller;

import com.example.rentcar.dao.entity.RentCarEntity;
import com.example.rentcar.model.*;
import com.example.rentcar.service.CarCommentsService;
import com.example.rentcar.service.CarsService;
import com.example.rentcar.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/saveCarComments")
    public String saveCarComments(@RequestBody CarCommentsDto carCommentsDto) {

        carCommentsService.saveCarComments(carCommentsDto);
        return "redirect:/rentCar/car-single/" + carCommentsDto.getCar_id();

    }


    @GetMapping("/addCar")
    public String redirectCarAdd(Model model) {
        List<CarsDto> carsDtoList = carsService.getCarsList();
        model.addAttribute("cars", carsDtoList);

        return "addCar";
    }


    @GetMapping("/deleteCar/{carId}")
    public String deleteCar(@PathVariable("carId") Integer carId, Model model) {
        carsService.deleteCar(carId);

        return "redirect:/admin/admin/";
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
    public String saveCar(@RequestParam("image") MultipartFile car_image,
                          CarsDto carsDto
    ) throws IOException {
        carsService.saveCar(carsDto, car_image);
        return "redirect:/admin/admin/";
    }

    @PostMapping("/editSaveCar/{id}")
    public String editSaveCar(@PathVariable Integer id,
                              @RequestParam("image") MultipartFile car_image,
                              CarsDto carsDto
    ) throws IOException {
        carsService.editSaveCar(id, car_image, carsDto);
        return "redirect:/admin/admin/";
    }


    @GetMapping("/rent/{carId}")
    public String redirectRent(@PathVariable("carId") Integer carId,
                               Model model) {
        CarsDto carsDto = carsService.getCar(carId);
        model.addAttribute("car", carsDto);

        List<RentCarEntity> rentCarEntityList = carsService.getRentCarList();
        model.addAttribute("rentCar", rentCarEntityList);
        return "rentCar";
    }

//    @PostMapping("/checkRentCar")
//    public String checkRentCar(@RequestBody RentCarEntity rentCarEntity
//    ) {
//        var res = carsService.checkRentCar(rentCarEntity);
//        return "{\"test\":\"data\"}";
//    }
}
