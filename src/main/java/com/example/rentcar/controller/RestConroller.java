package com.example.rentcar.controller;

import com.example.rentcar.dao.entity.RentCarEntity;
import com.example.rentcar.service.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class RestConroller {
    CarsService carsService;

    @PostMapping("/checkRentCar")
    public String checkRentCar(@RequestBody RentCarEntity rentCarEntity
    ) {
        var res=carsService.checkRentCar(rentCarEntity);
        return "{\"result\":\"%s\"}".formatted(res) ;
    }

}
