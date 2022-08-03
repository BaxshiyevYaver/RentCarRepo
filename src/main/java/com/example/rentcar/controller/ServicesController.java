package com.example.rentcar.controller;

import com.example.rentcar.model.ServicesDto;
import com.example.rentcar.service.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class ServicesController {
    ServicesService servicesService;

    @GetMapping("/services")
    public String getServices(Model model) {
        List<ServicesDto> servicesDtoList = servicesService.getServicesList();
        model.addAttribute("services", servicesDtoList);
        return "services";
    }
}
